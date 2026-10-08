
//PARTE III
//No todos los objetos del dominio poseen la misma capacidad adicional. Esa capacidad debe modelarse
//mediante un contrato independiente de la jerarquía principal.


//testeo casa / departamento con interfaz /



public class Main {
    public static void main(String[] args) {

        Casa miCasa = new Casa("CASA-666", 120, 3, true);
        System.out.println(miCasa);
        System.out.println("Arriendo base casa: " + miCasa.calcularCostoArriendo()+ "Pesos");

        System.out.println("\n");

        Departamento miDepto = new Departamento("DEP-201", 55, 2, 4, true);
        System.out.println(miDepto);
        System.out.println("Tiene estacionamiento inicial: " + miDepto.tieneEstacionamientoAsignado());


        miDepto.asignarEstacionamiento();
        System.out.println("Tiene estacionamiento tras activar: " + miDepto.tieneEstacionamientoAsignado());
    }
}