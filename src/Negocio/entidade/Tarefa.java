package Negocio.entidade;

public class Tarefa {
    private Funcionario responsavel;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private TimelineTarefa[] timelineTarefa;
    private int indiceTimeline;
    private boolean marcaFinalizadoFuncionario;
    private boolean marcaFinalizadoGerente;

    public Tarefa(Funcionario resposavel, String descricao, String dataInicio, String dataTermino) {
        this.responsavel = resposavel;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.timelineTarefa = new TimelineTarefa[5];
        this.indiceTimeline = 0;
        this.timelineTarefa[indiceTimeline] = new TimelineTarefa();
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }	

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public boolean getMarcaFinalizadoFuncionario() {
        return marcaFinalizadoFuncionario;
    }

    public void setMarcaFinalizadoFuncionario(boolean MarcaFinalizadoFuncionario) {
        this.marcaFinalizadoFuncionario = MarcaFinalizadoFuncionario;
        if (MarcaFinalizadoFuncionario == true) {
            if (this.timelineTarefa[this.indiceTimeline].getDataMarcaFuncionario() == null) {
                this.timelineTarefa[this.indiceTimeline].setDataMarcaFuncionario();
            }
            else {
                this.indiceTimeline ++;
                this.timelineTarefa[indiceTimeline] = new TimelineTarefa();
                this.timelineTarefa[this.indiceTimeline].setDataMarcaFuncionario();
            }
        }
        else {
            if (this.timelineTarefa[this.indiceTimeline].getDataMarcaGerente() == null) {
                this.timelineTarefa[this.indiceTimeline].setDataMarcaGerente();
            }
        }
    }

    public boolean getMarcaFinalizadoGerente() {
        return marcaFinalizadoGerente;
    }

    public void setMarcaFinalizadoGerente(boolean marcaFinalizadoGerente) {
        this.marcaFinalizadoGerente = marcaFinalizadoGerente;
        this.timelineTarefa[this.indiceTimeline].setDataMarcaGerente();
    }
    
    public void mudarTagTimeline(String tag) {
        if (this.timelineTarefa[this.indiceTimeline].getTag() == null) {
            this.timelineTarefa[this.indiceTimeline].setTag(tag);
        }
    }
    
    public void adicionarNotaFuncionario(String nota){
        this.timelineTarefa[this.indiceTimeline].setNotaFuncionario(nota);
    }
    
    public void adicionarNotaGerente(String nota){
        this.timelineTarefa[this.indiceTimeline].setNotaGerente(nota);
    }

    @Override
    public String toString() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.timelineTarefa[i]);
        }
        return "Tarefa{" + "responsavel=" + responsavel + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", marcaFinalizadoFuncionario=" + marcaFinalizadoFuncionario + ", marcaFinalizadoGerente=" + marcaFinalizadoGerente + '}';
    }
}
