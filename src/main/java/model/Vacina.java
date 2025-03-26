package model;

// Classe que representa uma vacina
public class Vacina {
    private String nome;
    private String dataFabricacao;
    private String dataValidade;

    public Vacina(String nome, String dataFabricacao, String dataValidade) {
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Vacina: " + nome + " | Fabricação: " + dataFabricacao + " | Validade: " + dataValidade;
    }
}
