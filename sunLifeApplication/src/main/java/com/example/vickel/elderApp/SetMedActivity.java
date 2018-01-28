package com.example.vickel.elderApp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class SetMedActivity extends AppCompatActivity {

    private Button btnIncHour, btnDecHour, btnIncMin, btnDecMin, btnSetMed;
    private Spinner frequence;
    private EditText etHour, etMin;
    private CheckBox monday, tuesday, wednesday, thursday, friday, saturday, sunday;

    private int currentHour, currentMin;

    private String [] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_med);

        btnIncHour = (Button) findViewById(R.id.btnIncHour);
        btnDecHour = (Button) findViewById(R.id.btnDecHour);
        btnIncMin = (Button) findViewById(R.id.btnIncMin);
        btnDecMin = (Button) findViewById(R.id.btnDecMin);
        btnSetMed = (Button) findViewById(R.id.btnSetMed);

        frequence = (Spinner) findViewById(R.id.spinner);

        monday = (CheckBox) findViewById(R.id.checkMonday);
        tuesday = (CheckBox) findViewById(R.id.checkTuesday);
        wednesday = (CheckBox) findViewById(R.id.checkWednesday);
        thursday = (CheckBox) findViewById(R.id.checkThursday);
        friday = (CheckBox) findViewById(R.id.checkFriday);
        saturday = (CheckBox) findViewById(R.id.checkSaturday);
        sunday = (CheckBox) findViewById(R.id.checkSunday);

        etHour = (EditText) findViewById(R.id.etHour);
        etMin = (EditText) findViewById(R.id.etMin);

        String getEtHour = (etHour).getText().toString();
        currentHour = Integer.parseInt(getEtHour);

        String getEtMin = (etHour).getText().toString();
        currentMin = Integer.parseInt(getEtMin);

        days = new String[7];

        btnIncHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if( currentHour == 24){
                    currentHour = 0;
                    etHour.setText(String.valueOf(currentHour));

                }
                else if(currentHour <= 23){
                    currentHour++;
                    etHour.setText(String.valueOf(currentHour));
                }

            }
        });

        btnDecHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentHour == 0){
                    currentHour = 12;
                    etHour.setText(String.valueOf(currentHour));

                }
                else if(currentHour >0){
                    currentHour--;
                    etHour.setText(String.valueOf(currentHour));
                }

            }
        });

        btnIncMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentMin == 59){
                    currentMin = 0;
                    etMin.setText(String.valueOf(currentMin));

                }
                else if(currentMin <=58)
                {
                    currentMin++;
                    etMin.setText(String.valueOf(currentMin));
                }
            }
        });

        btnDecMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentMin == 0){
                    currentMin = 59;
                    etMin.setText(String.valueOf(currentMin));
                }
                else if(currentMin>0){
                    currentMin--;
                    etMin.setText(String.valueOf(currentMin));
                }

            }
        });


        btnSetMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Intent openNewAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
//                openNewAlarm.putExtra(AlarmClock.EXTRA_HOUR, currentHour);
//                openNewAlarm.putExtra(AlarmClock.EXTRA_MINUTES, currentMin);
//                startActivity(openNewAlarm);

                if(monday.isChecked())
                    days[0] = "monday";
                else
                    days[0] ="";



                Toast.makeText(SetMedActivity.this, days[0]+ "frequence "+ String.valueOf(frequence.getSelectedItem())
                        , Toast.LENGTH_SHORT).show();

            }
        });

    }
}
