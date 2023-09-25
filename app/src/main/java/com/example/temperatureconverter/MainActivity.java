package com.example.temperatureconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView showResult;
    private EditText editText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResult = findViewById(R.id.textView2);
        editText = findViewById(R.id.editTextTextPersonName);
        Button celBtn = findViewById(R.id.button);
        Button farBtn = findViewById(R.id.button2);

        celBtn.setOnClickListener(view -> {

            String editText_Value = editText.getText().toString();
            if(editText_Value.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Please enter temperature",Toast.LENGTH_LONG).show();
            }
            else
            {
                double dEditText = Double.parseDouble(editText_Value);
                double convertedValue = convertToCelsius(dEditText);
                double finalValue = Math.round(convertedValue *100.0)/100.0;
                String result = String.valueOf(finalValue);
                showResult.setText(result+"°C");
            }

        });

        farBtn.setOnClickListener(view -> {

            String editText_Value = editText.getText().toString();
            if(editText_Value.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Please enter temperature",Toast.LENGTH_LONG).show();
            }
            else
            {
                double dEditText = Double.parseDouble(editText_Value);
                double convertedValue = convertToFahrenheit(dEditText);
                double finalValue = Math.round(convertedValue *100.0)/100.0;
                String result = String.valueOf(finalValue);
                showResult.setText(result+"°F");
            }

        });
    }

    public double convertToCelsius(double farValue)
    {
        double resultInFahrenheit;
        resultInFahrenheit = (farValue-32) * 5/9;
        return resultInFahrenheit;

    }
    public double convertToFahrenheit(double celValue)
    {
        double resultInCelsius;
        resultInCelsius = (celValue * 9/5) +32;
        return resultInCelsius;

    }
}