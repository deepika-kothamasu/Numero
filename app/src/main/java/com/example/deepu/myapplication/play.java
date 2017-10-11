package com.example.deepu.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class play extends AppCompatActivity {


    public TextView ques,score,nsc;
    Button z0,o1,s2,close;
    int n=3,nscore=0,uscore=0,max=7,min=3;
    private question q=new question();
    Random rand = new Random();
    int cans=0,count=30;
    Thread t;
    boolean exit=true;
    ProgressIndicator mProgressIndicator4;
    float update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        z0=(Button)  findViewById(R.id.z0);
        o1=(Button)  findViewById(R.id.o1);
        s2=(Button)  findViewById(R.id.s2);
        score=(TextView) findViewById(R.id.score);
        nsc=(TextView) findViewById(R.id.nsc);
        ques=(TextView) findViewById(R.id.question);

        mProgressIndicator4 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator4);
        mProgressIndicator4.setForegroundColor(Color.parseColor("#000080"));//FFFAFA
        mProgressIndicator4.setBackgroundColor(Color.parseColor("#FFFAFA"));//000080
        mProgressIndicator4.setPieStyle(true);
        t=new Thread(){
            @Override
            public void run(){
                while(exit)
                {
                    try
                    {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                update +=0.0334;
                                mProgressIndicator4.setValue(update);
                                count--;

                                if(count==0)
                                {

                                    nscore++;
                                    uscore--;
                                    score.setText("Score   " + uscore);
                                    nsc.setText("wrong   " + nscore);
                                    if(nscore==3) {

                                        st();
                                        Intent i=new Intent(play.this,gameover.class);
                                        startActivity(i);
                                    }
                                    else{
                                        update=0;
                                        n=rand.nextInt(max-min)+min;
                                        count=30;

                                        updateQuestion();
                                    }
                                }
                            }
                        });
                    }
                    catch(InterruptedException e){ }

                }
            }
        }
        ;
        updateQuestion();
        t.start();
        z0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int y=Integer.parseInt(z0.getText().toString());
                if(cans==y) {
                    uscore++;
                    score.setText("Score   " + uscore);
                    n=rand.nextInt(max-min)+min;
                    count=30;

                    update=0;
                    updateQuestion();
                }
                else
                {
                    nscore++;
                    uscore--;
                    score.setText("Score   " + uscore);
                    nsc.setText("wrong   " + nscore);
                    if(nscore==3) {

                        st();
                        Intent i=new Intent(play.this,gameover.class);
                        startActivity(i);

                    }
                    else{
                        n=rand.nextInt(max-min)+min;
                        count=30;

                        update=0;
                        updateQuestion();
                    }
                }


            }
        });
        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y=Integer.parseInt(o1.getText().toString());
                if(cans==y) {
                    uscore++;
                    score.setText("Score   " + uscore);
                    n=rand.nextInt(max-min)+min;
                    count=30;

                    update=0;
                    updateQuestion();
                }
                else
                {
                    nscore++;
                    uscore--;
                    score.setText("Score   " + uscore);
                    nsc.setText("wrong   " + nscore);
                    if(nscore==3) {

                         st();
                        Intent i=new Intent(play.this,gameover.class);
                        startActivity(i);
                    }
                    else{
                        n=rand.nextInt(max-min)+min;
                        count=30;
                        update=0;

                        updateQuestion();
                    }
                }

            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y=Integer.parseInt(s2.getText().toString());
                if(cans==y) {
                    uscore++;
                    score.setText("Score   " + uscore);
                    n=rand.nextInt(max-min)+min;
                    count=30;
                    update=0;

                    updateQuestion();
                }
                else
                {
                    nscore++;
                    uscore--;
                    score.setText("Score   " + uscore);
                    nsc.setText("wrong   " + nscore);
                    if(nscore==3) {

                        st();
                        Intent i=new Intent(play.this,gameover.class);
                        startActivity(i);

                    }
                    else{
                        n=rand.nextInt(max-min)+min;
                        count=30;
                        update=0;

                        updateQuestion();
                    }
                }


            }
        });

    }
    public void updateQuestion() {
        int[] a = q.getQuestion(n);
        for (int i = 0; i < n; i++) {
            if (i == 0)
                ques.setText("" + a[i] + " ");
            else if (a[i] >= 0)
                ques.append("+" + a[i] + " ");
            else
                ques.append("" + a[i] + " ");

        }


             cans= q.correctAnswer();

    }
    public void st()
    {
        exit=false;
    }

}

