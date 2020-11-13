package com.example.geoguesser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mostrapregunta;
    TextView nombrepregunta;
    Button resposta1;
    Button resposta2;
    Button resposta3;
    Button resposta4;
    ProgressBar pujaprogress;
    TextView textViewhint;
    Button hint;
    private QuizViewModel quizviewmodel;
    public static final List <QuestionModel> preguntes= new ArrayList<QuestionModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizviewmodel= ViewModelProviders.of(this).get(QuizViewModel.class);
        mostrapregunta=findViewById(R.id.textpregunta);
        resposta1=findViewById(R.id.resposta1);
        resposta2=findViewById(R.id.resposta2);
        resposta3=findViewById(R.id.resposta3);
        resposta4=findViewById(R.id.resposta4);
        hint=findViewById(R.id.botonhint);
        textViewhint=findViewById(R.id.textviewpista);
        nombrepregunta=findViewById(R.id.nombrepregunta);
        pujaprogress=findViewById(R.id.barraprogres);

        afegirpreguntes();
        //Aquest metode serveix per posar aleatoriament les preguntes pero no he aconseguit que quan es giri la pantalla es queden la mateixa pregunta i respostas
        //Collections.shuffle(preguntes);
        refresh();

        resposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizviewmodel.getIndex()==11){
                    alertafinal();
                }else {
                    int resposta1id = preguntes.get(quizviewmodel.getIndex()).getResposta1();
                    checkAnswer(resposta1id);
                    nextAnswer();
                    refresh();
                }
            }
        });

        resposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizviewmodel.getIndex()==11){
                    alertafinal();
                }else {
                    int resposta2id = preguntes.get(quizviewmodel.getIndex()).getResposta2();
                    checkAnswer(resposta2id);
                    nextAnswer();
                    refresh();
                }
            }
        });

        resposta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizviewmodel.getIndex()==11){
                    alertafinal();
                }else {
                    int resposta3id = preguntes.get(quizviewmodel.getIndex()).getResposta3();
                    checkAnswer(resposta3id);
                    nextAnswer();
                    refresh();
                }
            }
        });

        resposta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizviewmodel.getIndex()==11){
                    alertafinal();
                }else {
                    int resposta4id = preguntes.get(quizviewmodel.getIndex()).getResposta4();
                    checkAnswer(resposta4id);
                    nextAnswer();
                    refresh();
                }
            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewhint.setText(preguntes.get(quizviewmodel.getIndex()).getCorrecta());
                textViewhint.setVisibility(View.VISIBLE);
                hint.setVisibility(View.INVISIBLE);
                quizviewmodel.disminueixHint();
                quizviewmodel.augmentaUsedHint();
            }
        });

    }


    private void afegirpreguntes(){
        preguntes.add(new QuestionModel(R.string.p1,R.string.p1resposta1,R.string.p1resposta2,R.string.p1resposta3,R.string.c1,R.string.c1));
        preguntes.add(new QuestionModel(R.string.p2,R.string.p2resposta2,R.string.p2resposta1,R.string.p2resposta3,R.string.c2,R.string.c2));
        preguntes.add(new QuestionModel(R.string.p3,R.string.p3resposta1,R.string.p3resposta2,R.string.c3,R.string.p3resposta3,R.string.c3));
        preguntes.add(new QuestionModel(R.string.p4,R.string.c4,R.string.p4resposta1,R.string.p4resposta2,R.string.p4resposta3,R.string.c4));
        preguntes.add(new QuestionModel(R.string.p5,R.string.p5resposta1,R.string.p5resposta2,R.string.c5,R.string.p5resposta3,R.string.c5));
        preguntes.add(new QuestionModel(R.string.p6,R.string.p6resposta1,R.string.c6,R.string.p6resposta2,R.string.p6resposta3,R.string.c6));
        preguntes.add(new QuestionModel(R.string.p7,R.string.p7resposta1,R.string.p7resposta2,R.string.p7resposta3,R.string.c7,R.string.c7));
        preguntes.add(new QuestionModel(R.string.p8,R.string.p8resposta1,R.string.p8resposta2,R.string.p8resposta3,R.string.c8,R.string.c8));
        preguntes.add(new QuestionModel(R.string.p9,R.string.p9resposta1,R.string.p9resposta2,R.string.c9,R.string.p9resposta3,R.string.c9));
        preguntes.add(new QuestionModel(R.string.p10,R.string.c10,R.string.p10resposta1,R.string.p10resposta2,R.string.p10resposta3,R.string.c10));
        preguntes.add(new QuestionModel(R.string.p11,R.string.p11resposta1,R.string.c11,R.string.p11resposta2,R.string.p11resposta3,R.string.c11));
        preguntes.add(new QuestionModel(R.string.p12,R.string.p12resposta1,R.string.p12resposta2,R.string.c12,R.string.p12resposta3,R.string.c12));
    }

    private void checkAnswer(int resposta){
        if(resposta==preguntes.get(quizviewmodel.getIndex()).getCorrecta()){
            Toast correcta=Toast.makeText(this,"Respuesta Correcta",Toast.LENGTH_LONG);
            correcta.show();
            quizviewmodel.augmentaScore(1.0);

        }else {
            Toast erronea= Toast.makeText(this,"Respuesta incorrecta",Toast.LENGTH_LONG);
            erronea.show();
            quizviewmodel.disminueixScore(0.5);
        }

    }

    private void nextAnswer(){
        quizviewmodel.augmentaindex();
    }

    private void refresh(){
        mostrapregunta.setText(preguntes.get(quizviewmodel.getIndex()).getPregunta());
        resposta1.setText(preguntes.get(quizviewmodel.getIndex()).getResposta1());
        resposta2.setText(preguntes.get(quizviewmodel.getIndex()).getResposta2());
        resposta3.setText(preguntes.get(quizviewmodel.getIndex()).getResposta3());
        resposta4.setText(preguntes.get(quizviewmodel.getIndex()).getResposta4());
        String numeropregunta="Pregunta "+(quizviewmodel.getIndex()+1)+" de 12";
        textViewhint.setVisibility(View.INVISIBLE);
        nombrepregunta.setText(numeropregunta);
        if(quizviewmodel.getHints()<=0){
            hint.setVisibility(View.INVISIBLE);
        }else {
            hint.setVisibility(View.VISIBLE);
        }
        quizviewmodel.augmentaBarraprogress(8.33);
        pujaprogress.setProgress(quizviewmodel.getPujabarraprogress());
    }

    private void alertafinal(){
        AlertDialog.Builder alerta=new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage("Tu score es: "+calcularScore())
                .setCancelable(false)
                .setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Reiniciar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        quizviewmodel.setIndex(0);
                        quizviewmodel.setUsedhints(0);
                        quizviewmodel.setPujabarraprogress(0);
                        quizviewmodel.setScore(1);
                        quizviewmodel.setHints(3);

                       refresh();
                    }
                });

        AlertDialog titulo=alerta.create();
        titulo.setTitle("Test Finalizado, Enhorabuena!");
        titulo.show();
    }

    private int calcularScore(){
       int total;
        total=(((int)quizviewmodel.getScore()*100)/12);
        return total;
    }


}