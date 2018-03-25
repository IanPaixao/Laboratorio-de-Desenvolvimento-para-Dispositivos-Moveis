package br.pucminas.computacao.ldddm.nothing_internacional;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {

    //Button button1;
   // Button button2;
   // Button button3;
   // Button button4;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    TextView textView1;
    TextView textView2;
    int globaltimesegundos = 0;
    int globaltimeminutos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button1=(Button)findViewById(R.id.button1);
        //button2=(Button)findViewById(R.id.button2);
        //button3=(Button)findViewById(R.id.button3);
        //button4=(Button)findViewById(R.id.button4);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        //textView3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textView1.setText(R.string.Nada);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textView1.setText(R.string.Nothing);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textView1.setText(R.string.Nada);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textView1.setText(R.string.Niente);

            }
        });

    }//end create

    @SuppressLint({"SimpleDateFormat" , "SetTextI18n" , "DefaultLocale"})
    @Override
    protected void onStart() {
        super.onStart();
        final String pattern = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        long tempo  = date.getTime();
        int segundos = (int)(tempo/1000000000);
        int minutos = (int)((tempo/1000000000)/60);
        String string;
        if(segundos < 60){
             string = segundos + " " + getString(R.string.Segundos);
        }// end if
        else{
             string = minutos + " " + getString(R.string.Minutos);

        }
        textView2.setText(getString(R.string.Starttime) + " " + dateFormat.format(date) + "  " + string);
    }//end start

    @SuppressLint ("SimpleDateFormat")
    @Override
    protected void onPause() {
        super.onPause();
        //DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        long tempo  = date.getTime();
        int pausedtimesegundos = (int)(tempo/1000000000);
        int pausedtimeminutos = (int)((tempo/1000000000)/60);
        holdthetimesegundos(pausedtimesegundos);
        holdthetimeminutos(pausedtimeminutos);

    }//fim pause

    @SuppressLint({"SimpleDateFormat" , "SetTextI18n" , "DefaultLocale"})
    @Override
    protected void onResume() {
        super.onResume();
        final String pattern = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        long tempo  = date.getTime();
        int resumetimesegundos = (int)(tempo/1000000000);
        int resumetimeminutos = (int)((tempo/1000000000)/60);
        int segundos = mathtimesegundos(resumetimesegundos,globaltimesegundos);
        int minutos = mathtimeminutos(resumetimeminutos, globaltimeminutos);
        String string;
        if(segundos < 60){
            string = segundos + " " + getString(R.string.Segundos);
        }// end if
        else{
            string = minutos + " " + getString(R.string.Minutos);

        }
        textView2.setText(getString(R.string.TimePaused) + " " + dateFormat.format(date) + "  " + string);

    }// end resume

    @SuppressLint ("SimpleDateFormat")
    @Override
    protected void onStop() {
        super.onStop();
        //DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        long tempo  = date.getTime();
        int stoppedtimesegundos = (int)(tempo/1000000000);
        int stoppedtimeminutos = (int)((tempo/1000000000)/60);
        holdthetimesegundos(stoppedtimesegundos);
        holdthetimeminutos(stoppedtimeminutos);
    }// end stop

    @SuppressLint({"SimpleDateFormat" , "SetTextI18n" , "DefaultLocale"})
    @Override
    protected void onRestart() {
        super.onRestart();
        final String pattern = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        long tempo  = date.getTime();
        int restarttimesegundos = (int)(tempo/1000000000);
        int restarttimeminutos = (int)((tempo/1000000000)/60);
        int segundos = mathtimesegundos(restarttimesegundos,globaltimesegundos);
        int minutos = mathtimeminutos(restarttimeminutos, globaltimeminutos);
        String string;
        if(segundos < 60){
            string = segundos + " " + getString(R.string.Segundos);
        }// end if
        else{
            string = minutos + " " + getString(R.string.Minutos);

        }
        textView2.setText(getString(R.string.timeStopped) + " " + dateFormat.format(date) + "  " + string);

    }// end restart

    public void holdthetimesegundos(int updatedtimesegundos){
         globaltimesegundos = updatedtimesegundos;
    }// end hold

    public void holdthetimeminutos(int updatetimeminutos){
        globaltimeminutos = updatetimeminutos;
    }// end hold minutos

    public int mathtimesegundos(int actualtime, int previoustime){
         int answer = previoustime - actualtime;
         if(answer < 0)answer = answer * (-1);
         else if ((answer == previoustime)||(answer == actualtime)) answer = 0;
         return answer;
    }// end math time segundos


    public int mathtimeminutos(int actualtime, int previoustime){
        int answer = previoustime - actualtime;
        if(answer < 0)answer = answer * (-1);
        else if ((answer == previoustime)||(answer == actualtime)) answer = 0;
        return answer;
    }// end math time minutos
}//end main activity