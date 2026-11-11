package cl.adumun.academiclabs.dsy1102.estacionsur.model;

public final class TallerVirtual extends Taller {
    private String plataforma;
    private boolean grabacionDisponible;

    /** Requerido para reconstruir objetos con Jackson. */
    public TallerVirtual() { super(); }

    public TallerVirtual(String codigo, String nombre, int duracionHoras, int cupos,
                         String plataforma, boolean grabacionDisponible) {
        super(codigo, nombre, duracionHoras, cupos);
        setPlataforma(plataforma);
        setGrabacionDisponible(grabacionDisponible);
    }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) {
        if (plataforma == null || plataforma.isBlank()) {
            throw new IllegalArgumentException("La plataforma es obligatoria para talleres virtuales.");
        }
        this.plataforma = plataforma.trim();
    }

    public boolean isGrabacionDisponible() { return grabacionDisponible; }
    public void setGrabacionDisponible(boolean grabacionDisponible) {
        this.grabacionDisponible = grabacionDisponible;
    }

    @Override
    public int calcularArancel() {
        return getDuracionHoras() * 7_000 + (grabacionDisponible ? 2_000 : 0);
    }

    @Override
    public String tipo() { return "Virtual"; }
}
