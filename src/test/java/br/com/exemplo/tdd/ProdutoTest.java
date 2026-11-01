package br.com.exemplo.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ProdutoTest {

    @Test
    void deveCadastrarProdutoValido() {
        Produto p = new Produto("Notebook", 3500.00);
        assertEquals("Notebook", p.getNome());
        assertEquals(3500.00, p.getPreco());
    }

    @Test
    void deveRejeitarNomeVazio() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Produto("", 1000.00));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveRejeitarNomeSomenteComEspacos() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Produto(" ", 1000.00));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveRejeitarNomeNulo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Produto(null, 1000.00));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveRejeitarPrecoZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Mouse", 0));
        assertEquals("Preço inválido", e.getMessage());
    }

    @Test
    void deveRejeitarPrecoNegativo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Teclado", -50.00));
        assertEquals("Preço inválido", e.getMessage());
    }

    // Desafio: preço com centavos é o caso mais comum numa loja; garante que a regra "> 0"
    // não rejeita decimais e que o double é guardado sem arredondamento.
    @Test
    void deveCadastrarProdutoComPrecoDecimal() {
        Produto p = new Produto("Cabo USB", 29.90);
        assertEquals("Cabo USB", p.getNome());
        assertEquals(29.90, p.getPreco());
    }

    // Desafio opcional: NaN não é maior que zero, mas "NaN <= 0" também é falso,
    // então escapava da validação. Regra proposta: rejeitar NaN como preço inválido.
    @Test
    void deveRejeitarPrecoNaN() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Produto("Monitor", Double.NaN));
        assertEquals("Preço inválido", e.getMessage());
    }
}
