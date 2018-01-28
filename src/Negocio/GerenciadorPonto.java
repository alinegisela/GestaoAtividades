package Negocio;

import Negocio.entidade.Ponto;
import Dados.RepositorioPonto;
import Negocio.excecoes.PontoCheioException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenciadorPonto {
    private final RepositorioPonto repositorioPonto;

    public GerenciadorPonto(RepositorioPonto repositorioPonto){
        this.repositorioPonto = repositorioPonto;
    }
    
    public void baterPonto(Ponto novoPonto) throws PontoCheioException {
        //seria interessante fazer um bloqueio para não bater o ponto logo em seguida. Dá um intervalo de 10min ou algo assim
        Ponto pontoSalvo = this.repositorioPonto.pontoExiste(novoPonto.getFuncionario(), novoPonto.getData());
        
        String hora = stringHoraAtual();
        
        
        //se eh o primeiro ponto que o funcionario bate no dia
        if (pontoSalvo == null) {
            novoPonto.adicionarHorario(hora);
            this.repositorioPonto.salvarPonto(novoPonto);
        }
        else{
            //se o funcionário já bateu o ponto 4 vezes, lança uma exceção
            if(pontoSalvo.getHorariosPontos()[3] == null){
                pontoSalvo.adicionarHorario(hora);
            }else{
                throw new PontoCheioException();
            }
        }
    }
    
    private String stringHoraAtual() {
        Date dataAtual = new Date();
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataAtual);
        return hora;
    }
}
