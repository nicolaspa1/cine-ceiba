package com.ceiba.afiliado.comando.fabrica;

import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import org.springframework.stereotype.Component;

@Component
public class FabricaAfiliado {
    public Afiliado crear(ComandoAfiliado comandoAfiliado) {
        return new Afiliado(
                comandoAfiliado.getId(),
                comandoAfiliado.getNombre(),
                comandoAfiliado.getTipoDocumento(),
                comandoAfiliado.getNumeroDocumento(),
                comandoAfiliado.getFechaNacimiento(),
                comandoAfiliado.getEmail(),
                comandoAfiliado.getDireccion(),
                comandoAfiliado.getTelefono(),
                comandoAfiliado.getFechaRegistro()

        );
    }
}
