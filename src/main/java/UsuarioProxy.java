import java.util.List;

public class UsuarioProxy implements IUsuario{

    private Usuario usuario;

    private String cpf;

    public UsuarioProxy(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.usuario == null) {
            this.usuario = new Usuario(this.cpf);
        }
        return this.usuario.obterDadosPessoais();
    }

    @Override
    public List<String> obterContatos(Administrador administrador) {
        if (!administrador.isValidado()) {
            throw new IllegalArgumentException("Faça login no sistema");
        }
        if (this.usuario == null) {
            this.usuario = new Usuario(this.cpf);
        }
        return this.usuario.obterContatos(administrador);
    }
}
