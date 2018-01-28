package Negocio.entidade;

import java.util.Date;

public class Ponto {
    private final Funcionario funcionario;
    private final String data;
    private String[] HorariosPontos;

    public Ponto(Funcionario funcionario, String data) {
        this.funcionario = funcionario;
        this.data = data;
        this.HorariosPontos = new String[4];
    }
    
    public void adicionarHorario(String hora) {
        for (int i = 0; i < this.HorariosPontos.length; i++) {
            if (this.HorariosPontos[i] == null) {
                this.HorariosPontos[i] = hora;
                break;
            }
        }
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getData() {
        return data;
    }

    public String getInicioExpediente() {
        return this.HorariosPontos[0];
    }

    public String getSaidaAlmoco() {
        return this.HorariosPontos[1];
    }
    
    public String getVoltaAlmoco() {
        return this.HorariosPontos[2];
    }
    
    public String getFimExpediente() {
        return this.HorariosPontos[3];
    }

    public String[] getHorariosPontos() {
        return HorariosPontos;
    }

   
    @Override
    public String toString() {
        return "Ponto [nome=" + getFuncionario() + ", data=" + getData() + ", inicioExpediente=" + getInicioExpediente() + ", saidaAlmoco=" + getSaidaAlmoco() + ", voltaAlmoco=" + getVoltaAlmoco() + ", fimExpediente=" + getFimExpediente() + "]";
    }
}