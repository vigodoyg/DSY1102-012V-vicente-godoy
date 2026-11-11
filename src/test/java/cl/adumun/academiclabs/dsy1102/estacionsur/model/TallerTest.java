package cl.adumun.academiclabs.dsy1102.estacionsur.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TallerTest {
    @Test
    void presencialConMaterialesCalculaArancel() {
        Taller taller = new TallerPresencial("T-P01", "Cerámica", 3, 18, "Sala A", true);
        assertEquals(33_500, taller.calcularArancel());
        assertEquals("Presencial", taller.tipo());
    }

    @Test
    void presencialSinMaterialesCalculaArancel() {
        Taller taller = new TallerPresencial("T-P02", "Grabado", 2, 12, "Sala B", false);
        assertEquals(20_000, taller.calcularArancel());
    }

    @Test
    void virtualConGrabacionCalculaArancel() {
        Taller taller = new TallerVirtual("T-V01", "Fotografía", 4, 25, "Sala digital", true);
        assertEquals(30_000, taller.calcularArancel());
        assertEquals("Virtual", taller.tipo());
    }

    @Test
    void virtualSinGrabacionCalculaArancel() {
        Taller taller = new TallerVirtual("T-V02", "Guion", 2, 15, "Online", false);
        assertEquals(14_000, taller.calcularArancel());
    }

    @Test
    void rechazaDuracionFueraDeRango() {
        assertThrows(IllegalArgumentException.class,
                () -> new TallerPresencial("A", "Taller", 0, 10, "Sala", false));
        assertThrows(IllegalArgumentException.class,
                () -> new TallerVirtual("A", "Taller", 41, 10, "Online", false));
    }

    @Test
    void rechazaCamposObligatorios() {
        assertThrows(IllegalArgumentException.class,
                () -> new TallerPresencial("   ", "Taller", 2, 12, "Sala", true));
        assertThrows(IllegalArgumentException.class,
                () -> new TallerVirtual("V1", " ", 2, 12, "Online", true));
        assertThrows(IllegalArgumentException.class,
                () -> new TallerVirtual("V1", "Taller", 2, 12, " ", true));
    }

    @Test
    void rechazaCuposFueraDeRango() {
        assertThrows(IllegalArgumentException.class,
                () -> new TallerPresencial("A", "Taller", 2, 0, "Sala", false));
        assertThrows(IllegalArgumentException.class,
                () -> new TallerVirtual("A", "Taller", 2, 41, "Online", false));
    }

    @Test
    void mantienePosibilidadDeReconstruccionConJackson() {
        TallerPresencial p = new TallerPresencial();
        p.setCodigo("  P-100  ");
        p.setNombre("  Dibujo  ");
        p.setDuracionHoras(1);
        p.setCupos(15);
        p.setSala("  Aula 1 ");
        p.setMaterialesIncluidos(true);
        assertEquals("P-100", p.getCodigo());
        assertEquals("Dibujo", p.getNombre());
        assertEquals(13_500, p.calcularArancel());
    }
}
