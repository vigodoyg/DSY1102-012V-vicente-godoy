
//PARTE II
//testeando la clase departamento y casa

public class Main {
    public static void main(String[] args) {

        Vivienda miCasa = new Casa("CASA-123", 120, 3, true);
        System.out.println(miCasa);
        System.out.println("Arriendo base: " + miCasa.calcularCostoArriendo() +  "pesos");
        System.out.println("Arriendo con 10% desc: " + miCasa.calcularCostoArriendo(10));
        System.out.println("\n");
        Vivienda miDepto = new Departamento("DEP-123123", 55, 2, 4, false);
        System.out.println(miDepto);
        System.out.println("Arriendo moroso: " + miDepto.calcularCostoArriendo()+  "pesos");
        System.out.println("Arriendo con 5% desc: " + miDepto.calcularCostoArriendo(5)+  "pesos");
    }
}