package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResult;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnSqrt, btnPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize view
        etNum1 = findViewById(R.id.et_num1);
        etNum2 = findViewById(R.id.et_num2);
        tvResult = findViewById(R.id.tv_result);
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);
        btnSqrt = findViewById(R.id.btn_sqrt);
        btnPercentage = findViewById(R.id.btn_percentage);

        // Set button click listeners
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.ADD);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.SUBTRACT);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.MULTIPLY);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.DIVIDE);
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.SQUARE_ROOT);
            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.PERCENTAGE);
            }
        });
    }

    private void performOperation(Operation operation) {
        String input1 = etNum1.getText().toString();
        String input2 = etNum2.getText().toString();

        if (input1.isEmpty() || (operation != Operation.SQUARE_ROOT && input2.isEmpty())) {
            tvResult.setText("Invalid input");
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = 0;
        if (operation != Operation.SQUARE_ROOT) {
            num2 = Double.parseDouble(input2);
        }

        double result = 0;
        switch (operation) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 != 0) {
                    result = num1 / m2;
                } else {
                    tvResult.setText("Cannot divide by zero");
                    return;
                }
                break;
            case SQUARE_ROOT:
                if (num1 >= 0) {
                    result = Math.sqrt(num1);
                } else {
                    tvResult.setText("Invalid input for sqrt");
                    return;
                }
                break;
            case PERCENTAGE:
                result = (num1 / num2 )* 100;
                break;
        }

        tvResult.setText("Result: " + result);
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, SQUARE_ROOT, PERCENTAGE
    }
}
