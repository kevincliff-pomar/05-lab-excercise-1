package com.pomar.a05_lab_exercise_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {

    private CheckBox cb1 = null;
    private CheckBox cb2 = null;
    private CheckBox cb3 = null;
    private CheckBox cb4 = null;
    //..............................
    private boolean cb1Value = false;
    private boolean cb2Value = false;
    private boolean cb3Value = false;
    private boolean cb4Value = false;

    private String[] degrees = {"ABM", "BSIT", "BSCS", "BSCPE", "MSIT", "MSCS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("SHS Registration UI");

        Button btnSubmit = findViewById(R.id.submit);

        //...................................................
        cb1 = findViewById(R.id.box1);
        cb2 = findViewById(R.id.box2);
        cb3 = findViewById(R.id.box3);
        cb4 = findViewById(R.id.box4);
        //....................................................
        cb1Value = cb1.isChecked();
        cb2Value = cb2.isChecked();
        cb3Value = cb3.isChecked();
        cb4Value = cb4.isChecked();


        RadioGroup genderRadio = findViewById(R.id.radioGroup);


        ArrayList<String> degreeDataSet = new ArrayList<>(Arrays.asList(degrees));

        Spinner degreeSpinner = findViewById(R.id.degree_spinner);
        degreeAdapterActivity adapter = new degreeAdapterActivity(this, R.layout.degree_spinner_item_layout, degreeDataSet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        degreeSpinner.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmitButtonClicked();
            }
        });
    }

    private void btnSubmitButtonClicked() {
        Toast.makeText(this, "Request Submitted.", Toast.LENGTH_SHORT).show();
    }
}
