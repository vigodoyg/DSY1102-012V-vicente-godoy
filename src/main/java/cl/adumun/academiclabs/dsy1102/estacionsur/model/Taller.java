package cl.adumun.academiclabs.dsy1102.estacionsur.model;

/** Modelo abstracto entregado: no reescribir sus reglas de dominio. */
public abstract class Taller {
    private String codigo;
    private String nombre;
    private int duracionHoras;
    private int cupos;

    /** Constructor para reconstrucción de objetos al leer JSON con Jackson. */
    public Taller() { }

    protected Taller(String codigo, String nombre, int duracionHoras, int cupos) {
        setCodigo(codigo);
        setNombre(nombre);
        setDuracionHoras(duracionHoras);
        setCupos(cupos);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código es obligatorio.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public int getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(int duracionHoras) {
        if (duracionHoras < 1 || duracionHoras > 40) {
            throw new IllegalArgumentException("La duración debe estar entre 1 y 40 horas.");
        }
        this.duracionHoras = duracionHoras;
    }

    public int getCupos() { return cupos; }
    public void setCupos(int cupos) {
        if (cupos < 1 || cupos > 40) {
            throw new IllegalArgumentException("Los cupos deben estar entre 1 y 40.");
        }
        this.cupos = cupos;
    }

    /** Arancel por participante, en pesos chilenos. */
    public abstract int calcularArancel();

    /** Modalidad para mostrar en una tabla; no se almacena como atributo JSON. */
    public abstract String tipo();
}
