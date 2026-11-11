package cl.adumun.academiclabs.dsy1102.estacionsur.repository;

import cl.adumun.academiclabs.dsy1102.estacionsur.model.Taller;
import java.io.IOException;
import java.util.List;

public interface TallerRepository {
    List<Taller> cargarTodos() throws IOException;
    void guardarTodos(List<Taller> talleres) throws IOException;
}