package org.example.util;

import org.example.personagens.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class PersonagemUtil {
    private static final Logger logger = LoggerFactory.getLogger(PersonagemUtil.class);

    public Personagem getHeroi(int escolhaHeroi) {
        try {
            List<Personagem> personagens = List.of(new Guerreiro(), new Barbaro(), new Paladino());
            return personagens.get(escolhaHeroi - 1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            logger.warn("Escolha inválida. Guerreiro escolhido por padrão.");
            return new Guerreiro();
        }
    }

    public Personagem getHeroiComIf(int escolhaHeroi) {
        Personagem heroi;
        if (escolhaHeroi == 1) {
            heroi = new Guerreiro();
        } else if (escolhaHeroi == 2) {
            heroi = new Barbaro();
        } else if (escolhaHeroi == 3) {
            heroi = new Paladino();
        } else {
            logger.warn("Escolha inválida. Guerreiro escolhido por padrão.");
            heroi = new Guerreiro();
        }
        return heroi;
    }

    public Personagem getHeroiComSwitchAntesJava14(int escolhaHeroi) {
        Personagem heroi;
        switch (escolhaHeroi) {
            case 1:
                heroi = new Guerreiro();
                break;
            case 2:
                heroi = new Barbaro();
                break;
            case 3:
                heroi = new Paladino();
                break;
            default:
                logger.warn("Escolha inválida. Guerreiro escolhido por padrão.");
                heroi = new Guerreiro();
                break;
        }
        return heroi;
    }

    public Personagem getMonstro() {
        List<Personagem> monstros = List.of(new Orc(), new Kobold(), new MortoVivo());
        Random random = new Random();
        int escolhaMonstro = random.nextInt(2);
        return monstros.get(escolhaMonstro);
    }
}
