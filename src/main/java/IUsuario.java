import java.util.List;

public interface IUsuario {

    List<String> obterDadosPessoais();
    List<String> obterContatos(Administrador admin);
}
