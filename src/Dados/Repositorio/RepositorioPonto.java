package Dados.Repositorio;

import Negocio.entidade.Funcionario;
import Negocio.entidade.Ponto;

public class RepositorioPonto {
    private final int capacidade = 50;
    private Ponto[] listaPonto;
    private int indicePonto;
    
    public RepositorioPonto() {
        this.listaPonto = new Ponto[capacidade];
        this.indicePonto = 0;
    }

    public boolean salvarPonto(Ponto ponto) {
        boolean resp = false;
        if (indicePonto <= capacidade) {
            listaPonto[indicePonto] = ponto;
            indicePonto++;
            resp = true;
        }
        return resp;
    }
    
    
    public Ponto pontoExiste(Funcionario funcionario, String data) {
        Ponto ponto = null;
        for(int i = 0; i < indicePonto; i++) {
            if (listaPonto[i].getFuncionario().equals(funcionario) && listaPonto[i].getData().equals(data)) {
                ponto = listaPonto[i];
                break;
            }
        }
        return ponto;
    }
    
    public Ponto[] returnListaPonto() {
        Ponto[] lista = new Ponto[indicePonto];
        for (int i = 0; i < this.indicePonto; i++) {
            lista[i] = this.listaPonto[i];
        }
        return lista;
    }
    
    /*
    public Ponto[] retornarPontosMensais(Funcionario funcionario, int mes, int ano) {
        int cont = 0;
        String texto = "" + mes + "/" + ano;
        for(int i = 0; i < indicePonto; i++) {
            if (listaPonto[i].getFuncionario().equals(funcionario) && listaPonto[i].getData().substring(3, 10).equals(texto)) {
                cont++;
            }
        }

        int cont2 = 0;
        Ponto[] listaPontos = new Ponto[cont];
        for(int i = 0; i < indicePonto; i++) {
            if (listaPonto[i].getFuncionario().equals(funcionario) && listaPonto[i].getData().substring(3, 10).equals(texto)) {
                listaPontos[cont2] = listaPonto[i];
                cont2++;
            }
        }
        return listaPontos;
    }

    
    public List<Ponto> retornarPontosMensais(Funcionario funcionario, int mes, int ano){
        List<Ponto> pontos = new ArrayList<>();
        List<Ponto> resultado = new ArrayList<>();
        pontos = Arrays.asList(listaPonto);

        String texto = "" + mes + "/" + ano;

        for(Ponto registro:pontos) {
            if(registro.getFuncionario().equals(funcionario) && (registro.getData().substring(3, 10).equals(texto))  ) {
                resultado.add(registro);
            }
        }

        return resultado;
    }
    */
    
    //metodo meramente de teste, para visualizar os objetos no repositorio.
    public void exibirObjetos() {
        for (int i = 0; i < indicePonto; i++) {
            System.out.printf("Objeto %d:\n%s\n\n", i+1, listaPonto[i]);
        }
    }
}
