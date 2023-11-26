package org.example;

import org.example.exception.DanoInvalidoException;
import org.example.personagens.Personagem;
import org.example.util.PersonagemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static org.example.util.GraphicsUtil.getBoasVindas;
import static org.example.util.GraphicsUtil.getMenu;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        getBoasVindas();
        Scanner scanner = new Scanner(System.in);
        logger.info("Digite o nickname:");
        String nickname = scanner.next();
        getMenu();
        logger.info("Escolha do Herói:");
        int escolhaHeroi = scanner.nextInt();
        PersonagemUtil personagemUtil = new PersonagemUtil();

        Personagem heroi = personagemUtil.getHeroi(escolhaHeroi);
        Personagem monstro = personagemUtil.getMonstro();
        int quantidadeDeRodadas = 0;

        while (batalhaAtiva(heroi, monstro)) {
            quantidadeDeRodadas++;
            int iniciativaHeroi;
            int iniciativaMonstro;

            do {
                iniciativaHeroi = heroi.calcularIniciativa();
                iniciativaMonstro = monstro.calcularIniciativa();
            } while (iniciativaHeroi == iniciativaMonstro);

            Personagem atacante, defensor;
            logger.debug("Iniciativa do {} é {}", heroi.getClasse(), iniciativaHeroi);
            logger.debug("Iniciativa do {} é {}", monstro.getClasse(), iniciativaMonstro);
            if (iniciativaHeroi > iniciativaMonstro) {
                atacante = heroi;
                defensor = monstro;
            } else {
                atacante = monstro;
                defensor = heroi;
            }

            if (conseguiuAtacar(atacante, defensor)) {
                logger.info("{} ATACOU", atacante.getClasse());
                int dano = atacante.calcularFatorDeDano();
                try {
                    defensor.sofrerDano(dano);
                } catch (DanoInvalidoException ex) {
                    defensor.sofrerDano(1);
                }

            } else {
                logger.info("Atacante não teve sucesso!");
            }
        }

        if (monstro.getPontosDeVida() <= 0) {
            logger.info("{} {} Venceu em: {} rodadas", heroi.getClasse(), nickname, quantidadeDeRodadas);
        } else {
            logger.info("{} Venceu em: {} rodadas", heroi.getClasse(), quantidadeDeRodadas);
        }
    }

    private static boolean batalhaAtiva(Personagem heroi, Personagem monstro) {
        return heroi.getPontosDeVida() > 0 || monstro.getPontosDeVida() > 0;
    }

    private static boolean conseguiuAtacar(Personagem atacante, Personagem defensor) {
        return atacante.calcularFatorDeAtaque() > defensor.calcularFatorDeDefesa();
    }
}
