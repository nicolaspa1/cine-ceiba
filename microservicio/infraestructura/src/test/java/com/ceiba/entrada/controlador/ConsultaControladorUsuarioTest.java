package com.ceiba.entrada.controlador;

import com.ceiba.ApplicationMock;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
//@WebMvcTest(ConsultaControladorUsuario.class)
public class ConsultaControladorUsuarioTest {
//
//    @Autowired
//    private MockMvc mocMvc;
//
//    @Test
//    public void listar() throws Exception {
//        // arrange
//
//        // act - assert
//        mocMvc.perform(get("/usuarios")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].nombre", is("test")));
//    }
//

}
