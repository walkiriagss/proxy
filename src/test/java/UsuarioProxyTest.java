import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addUsuario(new Usuario("João", "Juiz de Fora", "87569877","32698745", "111-111-111-11"));
        BD.addUsuario(new Usuario("Maria", "São domingos", "5556977", "3265984", "999-99-999-99"));
    }

    @Test
    void deveRetornarDadosPessoaisDoUsuario() {
        UsuarioProxy usuario = new UsuarioProxy("111-111-111-11");

        assertEquals(Arrays.asList("João", "Juiz de Fora", "111-111-111-11"), usuario.obterDadosPessoais());
    }

    @Test
    void deveRetonarContatoDoUsuario() {
        Administrador admin = new Administrador("ana@gmail.com", true);
        UsuarioProxy usuario = new UsuarioProxy("999-99-999-99");

        assertEquals(Arrays.asList("5556977", "3265984"), usuario.obterContatos(admin));
    }

    @Test
    void deveRetonarExcecaoAdministradorSemValidaccao() {
        try {
            Administrador admin = new Administrador("walkiria@gmail.com", false);
            UsuarioProxy usuario = new UsuarioProxy("111-111-111-11");

            usuario.obterContatos(admin);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Faça login no sistema", e.getMessage());
        }
    }
}