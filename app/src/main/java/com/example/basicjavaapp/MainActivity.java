package com.example.basicjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name, dept, spin_val;
    String[] gender = {"Male", "Female"};
    float prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e = findViewById(R.id.editText2);
        RadioGroup rg = findViewById(R.id.radioGroup);
        final RadioButton r1 = findViewById(R.id.radioButton5);
        final RadioButton r2 = findViewById(R.id.radioButton6);
        final Spinner s = findViewById(R.id.spinner2);
        RatingBar rb = findViewById(R.id.ratingBar2);
        Button b = findViewById(R.id.button2);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin_val = gender[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, gender);
        spin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // setting adapters to spinners
        s.setAdapter(spin_adapter);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (r1.isChecked()) dept = "B.Tech CSE";
                if (r2.isChecked()) dept = "B.Tech IT";
            }
        });

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                prog = rating;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = e.getText().toString().trim();
                Toast.makeText(getApplicationContext(),
                        "Name: " + name + "\nGender: " + spin_val + "\nDegree: " + dept + "\nProgramming Knowledge: " + prog,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}