import java.util.ArrayList;
import java.util.List;

public class GestorViviendas {

    private List<Vivienda> viviendas;

    public GestorViviendas() {
        this.viviendas = new ArrayList<>();
    }


    public void registrarVivienda(Vivienda vivienda) {
        if (vivienda != null) {
            this.viviendas.add(vivienda);
            System.out.println("Vivienda " + vivienda.getCodigoPropiedad() + " registrada exitosamente.");
        } else {
            System.out.println("No se puede registrar una vivienda nula.");
        }
    }

    public List<Vivienda> buscarPorCodigo(String criterio) {
        List<Vivienda> resultados = new ArrayList<>();
        if (criterio == null || criterio.trim().isEmpty()) {
            return resultados;
        }

        for (Vivienda v : this.viviendas) {
            if (v.getCodigoPropiedad().toUpperCase().contains(criterio.trim().toUpperCase())) {
                resultados.add(v);
            }
        }
        return resultados;
    }


    public void listarViviendas() {
        if (this.viviendas.isEmpty()) {
            System.out.println("No hay viviendas registradas en el gestor.");
            return;
        }

        System.out.println("\t LISTADO DE VIVIENDAS REGISTRADAS \n");
        for (Vivienda v : this.viviendas) {
            System.out.println(v.toString() + "  Costo arriendo: " + v.calcularCostoArriendo() + " pesos");
        }
    }


    public List<Vivienda> getViviendas() {
        return new ArrayList<>(this.viviendas);
    }
}