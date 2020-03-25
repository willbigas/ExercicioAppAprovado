package br.com.willbigas.model.enums;

public enum Situacao {

    APROVADO("Aprovado"),
    REPROVADO("Reprovado");

    private String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
