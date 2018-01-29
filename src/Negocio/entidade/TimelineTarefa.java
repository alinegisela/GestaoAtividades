package Negocio.entidade;

import java.util.Date;

public class TimelineTarefa {
    private Date dataMarcaFuncionario;
    private Date dataMarcaGerente;
    private String tag;
    private String notaFuncionario;
    private String notaGerente;

    public Date getDataMarcaFuncionario() {
        return dataMarcaFuncionario;
    }

    public void setDataMarcaFuncionario() {
        this.dataMarcaFuncionario = new Date();
    }
    
    public void setDataMarcaFuncionario(Date data) {
        this.dataMarcaFuncionario = data;
    }

    public Date getDataMarcaGerente() {
        return dataMarcaGerente;
    }

    public void setDataMarcaGerente() {
        this.dataMarcaGerente = new Date();
    }
    
    public void setDataMarcaGerente(Date data) {
        this.dataMarcaGerente = data;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNotaFuncionario() {
        return notaFuncionario;
    }

    public void setNotaFuncionario(String notaFuncionario) {
        this.notaFuncionario = notaFuncionario;
    }

    public String getNotaGerente() {
        return notaGerente;
    }

    public void setNotaGerente(String notaGerente) {
        this.notaGerente = notaGerente;
    }

    @Override
    public String toString() {
        return "TimelineTarefa{" + "dataMarcaFuncionario=" + dataMarcaFuncionario + ", dataMarcaGerente=" + dataMarcaGerente + ", tag=" + tag + ", notaFuncionario=" + notaFuncionario + ", notaGerente=" + notaGerente + '}';
    }
}
