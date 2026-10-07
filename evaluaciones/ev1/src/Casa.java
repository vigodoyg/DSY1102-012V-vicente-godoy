//El sistema debe representar Departamento y Casa.(esta clase es para casa)
public class Casa extends Vivienda {

    private boolean tienePatio;

    public Casa(String codigoPropiedad, double superficieM2, int numeroHabitaciones, boolean tienePatio) {
        super(codigoPropiedad, superficieM2, numeroHabitaciones);
        this.tienePatio = tienePatio;
    }
    public boolean isTienePatio() {
        return tienePatio;
    }

    public void setTienePatio(boolean tienePatio) {
        this.tienePatio = tienePatio;
    }

    @Override
    public double calcularCostoArriendo() {
        double costo = 250000;
        if (tienePatio) {
            costo = costo + (costo * 0.10); // Aumento del 10%
        }
        return costo;
    }
}
