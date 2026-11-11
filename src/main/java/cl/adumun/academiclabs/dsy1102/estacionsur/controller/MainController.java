package cl.adumun.academiclabs.dsy1102.estacionsur.controller;

import cl.adumun.academiclabs.dsy1102.estacionsur.model.Taller;
import cl.adumun.academiclabs.dsy1102.estacionsur.model.TallerPresencial;
import cl.adumun.academiclabs.dsy1102.estacionsur.model.TallerVirtual;
import cl.adumun.academiclabs.dsy1102.estacionsur.repository.JsonTallerRepository;
import cl.adumun.academiclabs.dsy1102.estacionsur.repository.TallerRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML private ComboBox<String> cbModalidad;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDuracion;
    @FXML private TextField txtCupos;

    @FXML private VBox boxPresencial;
    @FXML private TextField txtSala;
    @FXML private CheckBox chkMateriales;

    @FXML private VBox boxVirtual;
    @FXML private TextField txtPlataforma;
    @FXML private CheckBox chkGrabacion;

    @FXML private TableView<Taller> tablaTalleres;
    @FXML private TableColumn<Taller, String> colTipo;
    @FXML private TableColumn<Taller, String> colCodigo;
    @FXML private TableColumn<Taller, String> colNombre;
    @FXML private TableColumn<Taller, Number> colDuracion;
    @FXML private TableColumn<Taller, Number> colCupos;
    @FXML private TableColumn<Taller, String> colDetalle;
    @FXML private TableColumn<Taller, Number> colArancel;

    @FXML private Label lblMensaje;

    private final ObservableList<Taller> listaTalleres = FXCollections.observableArrayList();
    private final TallerRepository repository = new JsonTallerRepository();

    @FXML
    public void initialize() {
        cbModalidad.setItems(FXCollections.observableArrayList("Presencial", "Virtual"));
        cbModalidad.setOnAction(e -> actualizarEstadoCampos());
        actualizarEstadoCampos();

        // Vinculación de columnas a métodos del modelo entregado
        colTipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().tipo()));
        colCodigo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCodigo()));
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colDuracion.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getDuracionHoras()));
        colCupos.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCupos()));
        colArancel.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().calcularArancel()));

        colDetalle.setCellValueFactory(data -> {
            Taller t = data.getValue();
            if (t instanceof TallerPresencial p) {
                return new SimpleStringProperty("Sala: " + p.getSala() + (p.isMaterialesIncluidos() ? " (Mat. incl.)" : ""));
            } else if (t instanceof TallerVirtual v) {
                return new SimpleStringProperty("Plat: " + v.getPlataforma() + (v.isGrabacionDisponible() ? " (Con grab.)" : ""));
            }
            return new SimpleStringProperty("");
        });

        tablaTalleres.setItems(listaTalleres);

        // Carga inicial persistente desde JSON
        try {
            listaTalleres.addAll(repository.cargarTodos());
            mostrarMensaje("Cargados " + listaTalleres.size() + " talleres existentes.", false);
        } catch (IOException e) {
            mostrarMensaje("Error al cargar persistencia: " + e.getMessage(), true);
        }
    }

    private void actualizarEstadoCampos() {
        String seleccion = cbModalidad.getValue();
        if ("Presencial".equals(seleccion)) {
            boxPresencial.setDisable(false);
            boxVirtual.setDisable(true);
            txtPlataforma.clear();
            chkGrabacion.setSelected(false);
        } else if ("Virtual".equals(seleccion)) {
            boxPresencial.setDisable(true);
            boxVirtual.setDisable(false);
            txtSala.clear();
            chkMateriales.setSelected(false);
        } else {
            boxPresencial.setDisable(true);
            boxVirtual.setDisable(true);
        }
    }

    @FXML
    public void handleRegistrar() {
        String modalidad = cbModalidad.getValue();
        if (modalidad == null || modalidad.isBlank()) {
            mostrarMensaje("Debe seleccionar una modalidad.", true);
            return;
        }

        int duracion;
        try {
            duracion = Integer.parseInt(txtDuracion.getText().trim());
        } catch (NumberFormatException e) {
            mostrarMensaje("La duración debe ser un número entero válido.", true);
            return;
        }

        int cupos;
        try {
            cupos = Integer.parseInt(txtCupos.getText().trim());
        } catch (NumberFormatException e) {
            mostrarMensaje("Los cupos deben ser un número entero válido.", true);
            return;
        }

        Taller nuevoTaller;
        try {
            if ("Presencial".equals(modalidad)) {
                nuevoTaller = new TallerPresencial(
                        txtCodigo.getText(),
                        txtNombre.getText(),
                        duracion,
                        cupos,
                        txtSala.getText(),
                        chkMateriales.isSelected()
                );
            } else {
                nuevoTaller = new TallerVirtual(
                        txtCodigo.getText(),
                        txtNombre.getText(),
                        duracion,
                        cupos,
                        txtPlataforma.getText(),
                        chkGrabacion.isSelected()
                );
            }
        } catch (IllegalArgumentException e) {
            mostrarMensaje("Dato inválido: " + e.getMessage(), true);
            return;
        }

        listaTalleres.add(nuevoTaller);
        try {
            repository.guardarTodos(listaTalleres);
            mostrarMensaje("Taller registrado exitosamente.", false);
            limpiarFormulario();
        } catch (IOException e) {
            mostrarMensaje("Registrado en tabla, pero falló el archivo JSON: " + e.getMessage(), true);
        }
    }

    @FXML
    public void handleEliminar() {
        Taller seleccionado = tablaTalleres.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensaje("Debe seleccionar una fila de la tabla para eliminar.", true);
            return;
        }

        listaTalleres.remove(seleccionado);
        try {
            repository.guardarTodos(listaTalleres);
            mostrarMensaje("Taller eliminado correctamente.", false);
        } catch (IOException e) {
            mostrarMensaje("Eliminado de la tabla, pero falló el archivo JSON: " + e.getMessage(), true);
        }
    }

    @FXML
    public void limpiarFormulario() {
        txtCodigo.clear();
        txtNombre.clear();
        txtDuracion.clear();
        txtCupos.clear();
        txtSala.clear();
        chkMateriales.setSelected(false);
        txtPlataforma.clear();
        chkGrabacion.setSelected(false);
        cbModalidad.getSelectionModel().clearSelection();
        actualizarEstadoCampos();
    }

    private void mostrarMensaje(String texto, boolean esError) {
        lblMensaje.setText(texto);
        if (esError) {
            lblMensaje.setStyle("-fx-text-fill: #b30000; -fx-font-weight: bold;");
        } else {
            lblMensaje.setStyle("-fx-text-fill: #08765d; -fx-font-weight: bold;");
        }
    }
}