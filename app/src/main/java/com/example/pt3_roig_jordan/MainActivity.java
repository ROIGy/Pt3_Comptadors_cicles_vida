package com.example.pt3_roig_jordan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    EditText edTxtOnCreate;
    EditText edTxtOnStart;
    EditText edTxtOnRestart;
    EditText edTxtOnResume;
    EditText edTxtOnPause;
    EditText edTxtOnStop;
    EditText edTxtOnDestroy;
    int cCreate = 0;
    int cStart = 0;
    int cRestart = 0;
    int cResume = 0;
    int cPause = 0;
    int cStop = 0;
    int cDestroy = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTitle = findViewById(R.id.tvTitle);
        edTxtOnCreate = findViewById(R.id.edTxtOnCreate);
        edTxtOnStart = findViewById(R.id.edTxtOnStart);
        edTxtOnRestart = findViewById(R.id.edTxtOnRestart);
        edTxtOnResume = findViewById(R.id.edTxtOnResume);
        edTxtOnPause = findViewById(R.id.edTxtOnPause);
        edTxtOnStop = findViewById(R.id.edTxtOnStop);
        edTxtOnDestroy = findViewById(R.id.edTxtOnDestroy);

        cCreate ++;
        edTxtOnCreate.setText(String.valueOf(cCreate));

    }

    @Override
    protected void onStart(){
        super.onStart();
        cStart++;
        edTxtOnStart.setText(String.valueOf(cStart));

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        cRestart++;
        edTxtOnRestart.setText(String.valueOf(cRestart));
    }

    @Override
    protected void onResume() {
        super.onResume();
        cResume++;
        edTxtOnResume.setText(String.valueOf(cResume));
    }

    @Override
    protected void onPause() {
        super.onPause();
        cPause++;
        edTxtOnPause.setText(String.valueOf(cPause));
    }

    @Override
    protected void onStop() {
        super.onStop();
        cStop++;
        edTxtOnStop.setText(String.valueOf(cStop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cDestroy++;

        // Mostrem un missatge Toast per notificar que l'Activity es destrueix
        Toast.makeText(this, "onDestroy() executat. Total: " + cDestroy, Toast.LENGTH_SHORT).show();

        // També és una bona pràctica registrar-ho a la consola
        android.util.Log.d("Lifecycle", "onDestroy() executat. Comptador: " + cDestroy);
    }
}