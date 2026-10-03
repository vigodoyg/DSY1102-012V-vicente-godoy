//evaluacion parte 1



//Evidencia de IL 1.1
//Incluye en el código un comentario breve, escrito con tus palabras, que explique al menos una diferen-
//cia entre esta solución orientada a objetos y una solución puramente procedural o estructurada. Debe
//mencionar cómo Java usa tipos explícitos y cómo las clases agrupan datos y comportamiento.



//a diferencia de la programación estructurada (como lo visto en fundamentos de la programación con python), en POO utilizamos clases que agrupan los atributos
// con su repectivo metodo en un solo lugar, además que java te obliga a especificar cada dato segun su tipo (boolean, string, int, double) para
// controlar y validad la informacion dentro del propio objeto.








public class Vivienda {

    private String codigoPropiedad;
    private double superficieM2;
    private int numeroHabitaciones;

    public Vivienda(String codigoPropiedad, double superficieM2, int numeroHabitaciones) {
        setCodigoPropiedad(codigoPropiedad);
        setSuperficieM2(superficieM2);
        setNumeroHabitaciones(numeroHabitaciones);
    }

    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(String codigoPropiedad) {
        if (codigoPropiedad == null || codigoPropiedad.trim().isEmpty()) {
            throw new IllegalArgumentException("el codigo de la propiedad no puede ser nulo ni vacío.");
        }
        this.codigoPropiedad = codigoPropiedad.trim();
    }

    public double getSuperficieM2() {
        return superficieM2;
    }

    public void setSuperficieM2(double superficieM2) {
        if (superficieM2 < 20 || superficieM2 > 500) {
            throw new IllegalArgumentException("La superficie debe estar entre 20 y 500 m2.");
        }
        this.superficieM2 = superficieM2;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        if (numeroHabitaciones <= 0) {
            throw new IllegalArgumentException("El número de habitaciones debe ser mayor que cero.");
        }
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String toString() {
        return "Código: " + codigoPropiedad + " | Superficie: " + (int) superficieM2;
    }
}