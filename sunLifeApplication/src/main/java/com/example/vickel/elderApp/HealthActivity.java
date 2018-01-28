package com.example.vickel.elderApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthActivity extends AppCompatActivity {

    private Button btnSetMed, btnSetDoct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

//        btnSchedule = (Button) findViewById(R.id.btnSchedule);
        btnSetDoct = (Button) findViewById(R.id.btnSetDoctor);
        btnSetMed = (Button) findViewById(R.id.btnSetMed);


        btnSetDoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HealthActivity.this, SetDoctorActivity.class);
                startActivity(intent);
            }
        });

        btnSetMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HealthActivity.this, SetMedActivity.class);
                startActivity(intent);
            }
        });

    }
}
