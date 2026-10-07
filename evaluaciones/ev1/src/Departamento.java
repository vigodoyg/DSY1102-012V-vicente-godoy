//El sistema debe representar Departamento y Casa.(esta clase es para departametento)


public class Departamento extends Vivienda {
        private int numeroPiso;
        private boolean gastoComunAlDia;

        public Departamento(String codigoPropiedad, double superficieM2, int numeroHabitaciones, int numeroPiso, boolean gastoComunAlDia) {
            super(codigoPropiedad, superficieM2, numeroHabitaciones);
            this.numeroPiso = numeroPiso;
            this.gastoComunAlDia = gastoComunAlDia;
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

        @Override
        public double calcularCostoArriendo() {
            double costo = 180000;
            if (!gastoComunAlDia) {
                costo = costo + (costo * 0.15); // Aumento del 15%
            }
            return costo;
        }
    }
