package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumberInput, secondNumberInput;
    TextView resultDisplay;
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberInput = findViewById(R.id.inputFirstNumber);
        secondNumberInput = findViewById(R.id.inputSecondNumber);
        resultDisplay = findViewById(R.id.displayResult);
        addButton = findViewById(R.id.buttonAdd);
        subtractButton = findViewById(R.id.buttonSubtract);
        multiplyButton = findViewById(R.id.buttonMultiply);
        divideButton = findViewById(R.id.buttonDivide);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operation) {
        double num1 = Double.parseDouble(firstNumberInput.getText().toString());
        double num2 = Double.parseDouble(secondNumberInput.getText().toString());
        double result;

        switch (operation) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 != 0) result = num1 / num2;
                else {
                    resultDisplay.setText("Cannot divide by zero");
                    return;
                }
                break;
            default: return;
        }
        resultDisplay.setText(String.format("%.2f", result));
    }
}
