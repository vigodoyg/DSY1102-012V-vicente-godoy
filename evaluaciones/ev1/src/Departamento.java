

public class Departamento extends Vivienda implements ConEstacionamiento {

    private int numeroPiso;
    private boolean gastoComunAlDia;
    private boolean estacionamientoAsignado = false;

    public Departamento(String codigoPropiedad, double superficieM2, int numeroHabitaciones,
                        int numeroPiso, boolean gastoComunAlDia) {
        super(codigoPropiedad, superficieM2, numeroHabitaciones);
        this.numeroPiso = numeroPiso;
        this.gastoComunAlDia = gastoComunAlDia;
        this.estacionamientoAsignado = false;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public boolean isGastoComunAlDia() {
        return gastoComunAlDia;
    }

    public void setGastoComunAlDia(boolean gastoComunAlDia) {
        this.gastoComunAlDia = gastoComunAlDia;
    }

    public boolean isEstacionamientoAsignado() {
        return estacionamientoAsignado;
    }

    public void setEstacionamientoAsignado(boolean estacionamientoAsignado) {
        this.estacionamientoAsignado = estacionamientoAsignado;
    }

    @Override
    public boolean tieneEstacionamientoAsignado() {
        return this.estacionamientoAsignado;
    }

    @Override
    public void asignarEstacionamiento() {
        this.estacionamientoAsignado = true;
    }

    @Override
    public double calcularCostoArriendo() {
        double costo = 180000;
        if (!gastoComunAlDia) {
            costo = costo + (costo * 0.15);
        }
        return costo;
    }
}