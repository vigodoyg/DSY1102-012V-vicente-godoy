package cl.adumun.academiclabs.dsy1102.estacionsur.model;

public final class TallerPresencial extends Taller {
    private String sala;
    private boolean materialesIncluidos;

    /** Requerido para reconstruir objetos con Jackson. */
    public TallerPresencial() { super(); }

    public TallerPresencial(String codigo, String nombre, int duracionHoras, int cupos,
                           String sala, boolean materialesIncluidos) {
        super(codigo, nombre, duracionHoras, cupos);
        setSala(sala);
        setMaterialesIncluidos(materialesIncluidos);
    }

    public String getSala() { return sala; }
    public void setSala(String sala) {
        if (sala == null || sala.isBlank()) {
            throw new IllegalArgumentException("La sala es obligatoria para talleres presenciales.");
        }
        this.sala = sala.trim();
    }

    public boolean isMaterialesIncluidos() { return materialesIncluidos; }
    public void setMaterialesIncluidos(boolean materialesIncluidos) {
        this.materialesIncluidos = materialesIncluidos;
    }

    @Override
    public int calcularArancel() {
        return getDuracionHoras() * 10_000 + (materialesIncluidos ? 3_500 : 0);
    }

    @Override
    public String tipo() { return "Presencial"; }
}
