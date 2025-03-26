package test;

import model.CatalogoVacinas;
import model.Vacina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Testes automatizados
class CatalogoVacinasTest {
    @Test
    void testAdicionarVacina() {
        CatalogoVacinas catalogo = new CatalogoVacinas();
        Vacina vacina = new Vacina("Vacina A", "01/01/2024", "01/01/2025");
        catalogo.adicionarVacina(vacina);
        assertEquals(1, catalogo.listarVacinas().size());
    }

    @Test
    void testRemoverVacina() {
        CatalogoVacinas catalogo = new CatalogoVacinas();
        Vacina vacina = new Vacina("Vacina B", "01/02/2024", "01/02/2025");
        catalogo.adicionarVacina(vacina);
        catalogo.removerVacina("Vacina B");
        assertEquals(0, catalogo.listarVacinas().size());
    }

    @Test
    void testListarVacinas() {
        CatalogoVacinas catalogo = new CatalogoVacinas();
        catalogo.adicionarVacina(new Vacina("Vacina C", "01/03/2024", "01/03/2025"));
        catalogo.adicionarVacina(new Vacina("Vacina D", "01/04/2024", "01/04/2025"));
        assertEquals(2, catalogo.listarVacinas().size());
    }

    @Test
    void testRemoverVacinaInexistente() {
        CatalogoVacinas catalogo = new CatalogoVacinas();
        catalogo.removerVacina("Vacina X");
        assertEquals(0, catalogo.listarVacinas().size());
    }
}
