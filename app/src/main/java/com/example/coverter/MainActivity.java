package com.example.coverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       EditText editText;
       TextView textView;
       Button button;
       //View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextNumberDecimal);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        ConstraintLayout layout=findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor("#FFEFDC7C"));
        // Inside your Activity or Fragment
        Spinner spinner = findViewById(R.id.spinner);

// Sample data
        String[] options = {"SELECT", "CGPA", "percentage"};

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // Inside your Activity or Fragment
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selected item
                String selectedOption = options[position];
                // Do something with the selected option
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(selectedOption=="CGPA"){
                            float c=Float.parseFloat(editText.getText().toString());
                            double res= (c-0.75)*10;
                            textView.setText("Perecentage is "+Double.toString(res)+"%");

                        } else if (selectedOption=="percentage") {
                            float c=Float.parseFloat(editText.getText().toString());
                            double res= (c/10)+0.75;
                            textView.setText("CGPA is "+Double.toString(res));

                        }
                        else{
                            Toast.makeText(MainActivity.this, "you have to select an option", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });





    }
    public void click(View v){
      textView.setText("");
      editText.setText("");
    }

}