package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphicsUtil {
    private static final Logger logger = LoggerFactory.getLogger(GraphicsUtil.class);

    public static void getMenu() {
        logger.info("=============================");
        logger.info("Digite a Classe do seu herói:");
        logger.info("1 - Guerreiro");
        logger.info("2 - Bárbaro");
        logger.info("3 - Paladino");
        logger.info("=============================");
    }

    public static void getBoasVindas() {
        logger.info("=============================");
        logger.info("Bem vindo ao Medieval Battle");
        logger.info("=============================");
        logger.info("Digite Seu nickname:");
    }
}

