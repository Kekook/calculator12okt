package com.example.calculator12okt.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculator12okt.R;
import com.example.calculator12okt.model.CalculatorImpl;
import com.example.calculator12okt.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CalculatorView {
    private TextView resultTxt;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTxt = findViewById(R.id.result_text);
        presenter = new CalculatorPresenter(this, new CalculatorImpl());
        Map<Integer,Integer>  digits = new HashMap<>();
        digits.put(R.id.but_1,1);
        digits.put(R.id.but_2,2);
        digits.put(R.id.but_3,3);
        digits.put(R.id.but_4,4);
        digits.put(R.id.but_5,5);
        digits.put(R.id.but_6,6);
        digits.put(R.id.but_7,7);
        digits.put(R.id.but_8,8);
        digits.put(R.id.but_9,9);
        digits.put(R.id.but_0,0);



        View.OnClickListener digitClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));

            }
        };



        findViewById(R.id.but_1).setOnClickListener(digitClickListener);
        findViewById(R.id.but_2).setOnClickListener(digitClickListener);
        findViewById(R.id.but_3).setOnClickListener(digitClickListener);
        findViewById(R.id.but_4).setOnClickListener(digitClickListener);
        findViewById(R.id.but_5).setOnClickListener(digitClickListener);
        findViewById(R.id.but_6).setOnClickListener(digitClickListener);
        findViewById(R.id.but_7).setOnClickListener(digitClickListener);
        findViewById(R.id.but_8).setOnClickListener(digitClickListener);
        findViewById(R.id.but_9).setOnClickListener(digitClickListener);
        findViewById(R.id.but_0).setOnClickListener(digitClickListener);

        Map<Integer, Operator>  operators = new HashMap<>();
        operators.put(R.id.but_plus,Operator.ADD);
        operators.put(R.id.but_minus,Operator.MIN);
        operators.put(R.id.but_div,Operator.DIV);
        operators.put(R.id.but_mult,Operator.MULT);


        View.OnClickListener operatorsClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));

            }
        };
        findViewById(R.id.but_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.but_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.but_div).setOnClickListener(operatorsClickListener);
        findViewById(R.id.but_mult).setOnClickListener(operatorsClickListener);

        findViewById(R.id.but_demi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnDemiPressed ();
            }
        });


    }


    @Override
    public void showResult(String result) {
        resultTxt.setText(result);

    }
}