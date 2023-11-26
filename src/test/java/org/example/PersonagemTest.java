package org.example;

import org.example.exception.DanoInvalidoException;
import org.example.personagens.Personagem;
import org.example.util.PersonagemUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para a classe Personagem")
public class PersonagemTest {

    private Personagem personagem;
    private static final Logger logger = LoggerFactory.getLogger(PersonagemTest.class);
    @BeforeEach
    void setUp() {
        PersonagemUtil personagemUtil = new PersonagemUtil();
        personagem = personagemUtil.getPersonagem();
        logger.info("O personagem escolhido para o teste foi do tipo {}.", personagem.getClasse());
    }

    @Test
    @DisplayName("Sofrer dano deve subtrair pontos de vida")
    void sofrerDanoDeveSubtrairPontosDeVida() {
        int pontosDeVidaInicial = personagem.getPontosDeVida();
        int dano = 10;

        personagem.sofrerDano(dano);

        assertEquals(pontosDeVidaInicial - dano, personagem.getPontosDeVida());
    }

    @Test
    @DisplayName("Sofrer dano com valor negativo deve lançar exceção")
    void sofrerDanoComValorNegativoDeveLancarExcecao() {
        int danoNegativo = -5;

        assertThrows(DanoInvalidoException.class, () -> personagem.sofrerDano(danoNegativo));
    }

    @Test
    @DisplayName("Calcular fator de ataque deve retornar valor positivo")
    void calcularFatorDeAtaqueDeveRetornarValorPositivo() {
        int fatorDeAtaque = personagem.calcularFatorDeAtaque();

        assertTrue(fatorDeAtaque >= 0);
    }

    @Test
    @DisplayName("Calcular fator de defesa deve retornar valor positivo")
    void calcularFatorDeDefesaDeveRetornarValorPositivo() {
        int fatorDeDefesa = personagem.calcularFatorDeDefesa();

        assertTrue(fatorDeDefesa >= 0);
    }

    @Test
    @DisplayName("Calcular iniciativa deve retornar valor positivo")
    void calcularIniciativaDeveRetornarValorPositivo() {
        int iniciativa = personagem.calcularIniciativa();

        assertTrue(iniciativa >= 0);
    }

    @Test
    @DisplayName("Sofrer dano com valor zero deve lançar exceção")
    void sofrerDanoComValorZeroDeveLancarExcecao() {
        int danoZero = 0;

        assertThrows(DanoInvalidoException.class, () -> personagem.sofrerDano(danoZero));
    }

    @Test
    @DisplayName("ToString deve retornar string formatada")
    void toStringDeveRetornarStringFormatada() {
        String toStringResult = personagem.toString();

        assertNotNull(toStringResult);
        assertTrue(toStringResult.contains("Personagem"));
        assertTrue(toStringResult.contains("pontosDeVida="));
        assertTrue(toStringResult.contains("classe="));
    }
}
