//PARTE IV
//Continuidad: ya existe la jerarquía completa y la capacidad opcional.
//

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorViviendas gestor = new GestorViviendas();


        Casa casa1 = new Casa("CASA-321", 120, 3, true);
        Casa casa2 = new Casa("CASA-123", 90, 2, false);
        Departamento depto1 = new Departamento("DEP-987", 55, 2, 4, false);
        Departamento depto2 = new Departamento("DEP-789", 70, 3, 8, true);

        System.out.println("\t\tREGISTROS\n");
        gestor.registrarVivienda(casa1);
        gestor.registrarVivienda(casa2);
        gestor.registrarVivienda(depto1);
        gestor.registrarVivienda(depto2);

        System.out.println();


        gestor.listarViviendas();

        System.out.println();

        System.out.println("\t\tPRUEBA DE BÚSQUEDA\n ");
        String busqueda = "DEP";
        List<Vivienda> encontradas = gestor.buscarPorCodigo(busqueda);
        System.out.println("\tCoincidencias encontradas para '" + busqueda + "': " + encontradas.size());
        for (Vivienda v : encontradas) {
            System.out.println(" -> Encontrada: " + v.getCodigoPropiedad() + " ($" + v.calcularCostoArriendo() + " pesos)");
        }
    }
}