package model;

import java.util.ArrayList;
import java.util.List;

// Singleton para gerenciar o catálogo de vacinas
public class CatalogoVacinas {
    private static CatalogoVacinas instancia;
    private List<Vacina> vacinas;

    public CatalogoVacinas() {
        vacinas = new ArrayList<>();
    }

    public static CatalogoVacinas getInstance() {
        if (instancia == null) {
            instancia = new CatalogoVacinas();
        }
        return instancia;
    }

    public void adicionarVacina(Vacina vacina) {
        vacinas.add(vacina);
    }

    public List<Vacina> listarVacinas() {
        return vacinas;
    }

    public void removerVacina(String nome) {
        boolean removido = vacinas.removeIf(v -> v.toString().contains(nome));

        if (!removido) {
            System.out.println("Erro: A vacina '" + nome + "' não foi encontrada no catálogo.");
        }
    }
}
