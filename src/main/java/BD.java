import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static Usuario getUsuario(String cpf) {
        return usuarios.get(cpf);
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getCpf(), usuario);
    }
}
