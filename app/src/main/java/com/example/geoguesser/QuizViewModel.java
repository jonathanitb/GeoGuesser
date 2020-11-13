package com.example.geoguesser;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    private int usedhints=0;
    private int pujabarraprogress;
    private double score=1;
    private  int hints=3;
    private int index=0;

    public int getUsedhints() {
        return usedhints;
    }

    public void setUsedhints(int usedhints) {
        this.usedhints = usedhints;
    }

    public int getPujabarraprogress() {
        return pujabarraprogress;
    }

    public void setPujabarraprogress(int pujabarraprogress) {
        this.pujabarraprogress = pujabarraprogress;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getHints() {
        return hints;
    }

    public void setHints(int hints) {
        this.hints = hints;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void augmentaindex(){
        index++;
    }

    public void augmentaUsedHint(){
        usedhints++;
    }

    public void disminueixHint(){
        hints--;
    }
    public void augmentaScore(double nombre){
        score+=nombre;
    }

    public void disminueixScore(double nombre){
        score-=nombre;
    }
    public void augmentaBarraprogress(double nombre){
        pujabarraprogress+=nombre;
    }
}
