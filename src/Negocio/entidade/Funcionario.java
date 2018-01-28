package Negocio.entidade;

public class Funcionario {
    private final String nome;
    private final String dataNascimento;
    private final String numIdentidade;
    private Endereco endereco;
    private String login;
    private String senha;
    private boolean ehGerente;

    public Funcionario(String nome, String dataNascimento, String numIdentidade, String login) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numIdentidade = numIdentidade;
        this.login = login;
        this.senha = "123";
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getNumIdentidade() {
        return numIdentidade;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEhGerente() {
        return ehGerente;
    }

    public void setEhGerente(boolean ehGerente) {
        this.ehGerente = ehGerente;
    }

    public boolean autenticar(String login, String senha){
        if(this.getLogin().equals(login) && this.getSenha().equals(senha)){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Funcionario [nome=" + getNome() + ", dataNascimento=" + getDataNascimento() + ", numIdentidade=" + getNumIdentidade() + ", " + getEndereco() + ", ehGerente=" + isEhGerente() + "]";
    }
}
