package ru.osmanov.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPlus, btnMinus, btnMulti, btnDiv, btnResult, btnDot, btnClear;
    private TextView textView;
    private double value1, value2;
    private String operator;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();

        btn0.setOnClickListener(view -> textView.setText(textView.getText() + "0"));
        btn1.setOnClickListener(view -> textView.setText(textView.getText() + "1"));
        btn2.setOnClickListener(view -> textView.setText(textView.getText() + "2"));
        btn3.setOnClickListener(view -> textView.setText(textView.getText() + "3"));
        btn4.setOnClickListener(view -> textView.setText(textView.getText() + "4"));
        btn5.setOnClickListener(view -> textView.setText(textView.getText() + "5"));
        btn6.setOnClickListener(view -> textView.setText(textView.getText() + "6"));
        btn7.setOnClickListener(view -> textView.setText(textView.getText() + "7"));
        btn8.setOnClickListener(view -> textView.setText(textView.getText() + "8"));
        btn9.setOnClickListener(view -> textView.setText(textView.getText() + "9"));
        btnDot.setOnClickListener(view -> textView.setText((textView.getText() + ".")));

        btnClear.setOnClickListener(view -> {
            value1 = 0.0;
            value2 = 0.0;
            textView.setText("");
        });

        btnPlus.setOnClickListener(view -> {
            operator = "\\+";
            textView.setText(textView.getText() + " + ");
        });

        btnMinus.setOnClickListener(view -> {
            operator = "-";
            textView.setText(textView.getText() + " - ");
        });

        btnMulti.setOnClickListener(view -> {
            operator = "\\*";
            textView.setText(textView.getText() + " * ");
        });

        btnDiv.setOnClickListener(view -> {
            operator = "/";
            textView.setText(textView.getText() + " / ");
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = 0;
                String splitValueOfTextView = textView.getText().toString();
                String[] arr = splitValueOfTextView.split(operator);
                value1 = Double.parseDouble(arr[0]);
                value2 = Double.parseDouble(arr[1]);
                try {
                    switch (operator) {
                        case ("\\+"):
                            result = value1 + value2;
                            break;
                        case ("-"):
                            result = value1 - value2;
                            break;
                        case ("\\*"):
                            result = value1 * value2;
                            break;
                        case ("/"):
                            result = value1 / value2;
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView.setText(" = " + result);
            }
        });
    }

    private void initView() {
        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        btnPlus = findViewById(R.id.button_plus);
        btnMinus = findViewById(R.id.button_minus);
        btnMulti = findViewById(R.id.button_multi);
        btnDiv = findViewById(R.id.button_div);
        btnDot = findViewById(R.id.button_dot);
        btnClear = findViewById(R.id.button_clear);
        btnResult = findViewById(R.id.button_result);
        textView = findViewById(R.id.tv_result);
    }
}
