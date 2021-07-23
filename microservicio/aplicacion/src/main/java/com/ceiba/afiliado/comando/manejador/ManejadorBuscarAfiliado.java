
package com.ceiba.afiliado.comando.manejador;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.afiliado.puerto.dao.DaoAfiliado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarAfiliado  {
    private final DaoAfiliado daoAfiliado;
    public ManejadorBuscarAfiliado(DaoAfiliado daoAfiliado) {
        this.daoAfiliado = daoAfiliado;
    }


    public DtoAfiliado ejecutar(Long id){
        return this.daoAfiliado.obtenerAfiliadoPorId(id);
    }


}
