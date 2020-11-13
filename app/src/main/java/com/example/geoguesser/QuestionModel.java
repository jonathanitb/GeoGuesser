package com.example.geoguesser;

public class QuestionModel {
    int pregunta;
    int resposta1;
    int resposta2;
    int resposta3;
    int resposta4;
    int correcta;

    public QuestionModel(int pregunta, int resposta1, int resposta2, int resposta3, int resposta4, int correcta) {
        this.pregunta = pregunta;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.correcta = correcta;
    }

    public int getPregunta() {
        return pregunta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }

    public int getResposta1() {
        return resposta1;
    }

    public void setResposta1(int resposta1) {
        this.resposta1 = resposta1;
    }

    public int getResposta2() {
        return resposta2;
    }

    public void setResposta2(int resposta2) {
        this.resposta2 = resposta2;
    }

    public int getResposta3() {
        return resposta3;
    }

    public void setResposta3(int resposta3) {
        this.resposta3 = resposta3;
    }

    public int getResposta4() {
        return resposta4;
    }

    public void setResposta4(int resposta4) {
        this.resposta4 = resposta4;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }
}
