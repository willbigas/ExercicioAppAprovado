package br.com.willbigas.controller;

import br.com.willbigas.model.Aluno;
import br.com.willbigas.model.enums.Situacao;

public class AlunoController {

    public Aluno calcular(Aluno aluno) {
        aluno.setMedia(calcularMedia(aluno.getNota1(), aluno.getNota2()));
        aluno.setSituacao(atribuirAprovacao(aluno));
        return aluno;
    }

    private Double calcularMedia(Double nota1, Double nota2) {
        return (nota1 + nota2) / 2;
    }

    private Situacao atribuirAprovacao(Aluno aluno) {
        if (aluno.getMedia() >= 7.0) {
            return Situacao.APROVADO;
        }
        return Situacao.REPROVADO;
    }

}
