package cl.adumun.academiclabs.dsy1102.estacionsur.repository;

import cl.adumun.academiclabs.dsy1102.estacionsur.model.Taller;
import cl.adumun.academiclabs.dsy1102.estacionsur.model.TallerPresencial;
import cl.adumun.academiclabs.dsy1102.estacionsur.model.TallerVirtual;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTallerRepository implements TallerRepository {

    private final File archivoPresenciales = new File("talleres_presenciales.json");
    private final File archivoVirtuales = new File("talleres_virtuales.json");
    private final ObjectMapper mapper;

    public JsonTallerRepository() {
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public List<Taller> cargarTodos() throws IOException {
        List<Taller> listaGeneral = new ArrayList<>();

        if (archivoPresenciales.exists() && archivoPresenciales.length() > 0) {
            List<TallerPresencial> presenciales = mapper.readValue(
                    archivoPresenciales,
                    new TypeReference<List<TallerPresencial>>() {}
            );
            listaGeneral.addAll(presenciales);
        }

        if (archivoVirtuales.exists() && archivoVirtuales.length() > 0) {
            List<TallerVirtual> virtuales = mapper.readValue(
                    archivoVirtuales,
                    new TypeReference<List<TallerVirtual>>() {}
            );
            listaGeneral.addAll(virtuales);
        }

        return listaGeneral;
    }

    @Override
    public void guardarTodos(List<Taller> talleres) throws IOException {
        List<TallerPresencial> presenciales = new ArrayList<>();
        List<TallerVirtual> virtuales = new ArrayList<>();

        for (Taller t : talleres) {
            if (t instanceof TallerPresencial p) {
                presenciales.add(p);
            } else if (t instanceof TallerVirtual v) {
                virtuales.add(v);
            }
        }

        mapper.writeValue(archivoPresenciales, presenciales);
        mapper.writeValue(archivoVirtuales, virtuales);
    }
}