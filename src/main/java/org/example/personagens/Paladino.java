package org.example.personagens;

import org.example.util.DadoUtil;

public class Paladino extends Personagem {
    public Paladino() {
        super(15,2,5,5,1, "Paladino");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dadoUtil = new DadoUtil();
        return (dadoUtil.rollD4() + dadoUtil.rollD4()) + getPontosDeForca();
    }

}
