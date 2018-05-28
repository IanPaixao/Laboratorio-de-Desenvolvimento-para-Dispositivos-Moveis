package br.pucminas.computacao.ldddm.trabalhopratico1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText nome;
    private EditText dataNasc;
    private EditText telefone;
    private EditText email;
    private Calendar cal;
    private Button data;
    private Button addpages;
    private Pessoa pessoa;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editText1);
        telefone = findViewById(R.id.editText2);
        email = findViewById(R.id.editText4);
        dataNasc= findViewById(R.id.editText3);
        data = findViewById(R.id.button2);

        mDisplayDate = findViewById(R.id.button2);
        mDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }// fim on click
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG,"onDateSet: date: " + year + "/" + month + "/" + day);
                String date = day + "/" + (month + 1) + "/" + year;
                mDisplayDate.setText(date);
                dataNasc.setText(date);
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.MONTH,month);
                cal.set(Calendar.DAY_OF_MONTH,day);
            }// fim data set
        };

        addpages = findViewById(R.id.button3);
        addpages.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent it = new Intent(MainActivity.this, DisplayActivity.class);
                                            startActivity(it);
                                        }
                                    }//
        );


    }// fim oncreate


    private void create() {

        pessoa = new Pessoa();
        pessoa.setNome(nome.getText().toString());
        pessoa.setTelefone(telefone.getText().toString());
        pessoa.setEmail(email.getText().toString());
        pessoa.setDataNasc(cal);

    }// fim create

    private void sDataNasc(){

        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, "Aniversario "+pessoa.getNome())
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, pessoa.getDataNasc().getTimeInMillis())
                .putExtra(CalendarContract.Events.ALL_DAY, true)
                .putExtra(CalendarContract.Events.RRULE,"FREQ=YEARLY")
                .putExtra(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,3);
        }// fim if

    }// fim datanasc

    public void sPessoa(){

        Intent intentPerson = new Intent(ContactsContract.Intents.Insert.ACTION);
        intentPerson.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intentPerson.putExtra(ContactsContract.Intents.Insert.NAME, pessoa.getNome())
                .putExtra(ContactsContract.Intents.Insert.PHONE, pessoa.getTelefone())
                .putExtra(ContactsContract.Intents.Insert.EMAIL, pessoa.getEmail())
                .putExtra(ContactsContract.Intents.Insert.DATA, pessoa.getDataNasc());
        startActivityForResult(intentPerson,2);

    }// fim pessoa

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2){
            sDataNasc();
        }else{
            wpp();
        }//fim else
    }//fim on activity result

    public void sContato(View view) {

        create();
        sPessoa();

    }// fim

    void wpp() {


        String text = "Bom Dia/Tarde/Noite! Seu número está nos meus contatos e criei um evento no dia do seu ániversario";
        PackageManager packageManager = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        try {
            String url = "https://api.whatsapp.com/send?phone=" + pessoa.getTelefone() + "&text=" + URLEncoder.encode(text, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                startActivityForResult(i,3);
            }//fim if
        } catch (Exception e) {
            e.printStackTrace();
        }// fim catch


    }//fim wpp
}//fim main activity
