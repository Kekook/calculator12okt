package com.example.calculator12okt.ui;

import com.example.calculator12okt.model.Calculator;
import com.example.calculator12okt.model.Operator;

public class CalculatorPresenter {
    private CalculatorView view ;
    private Calculator calc;
    private double argOne;

    public CalculatorPresenter(CalculatorView view, Calculator calc) {
        this.view = view;
        this.calc = calc;
    }

    public void onDigitPressed(int digit) {
        argOne = argOne * 10 + digit;
        view.showResult(String.valueOf(argOne));
    }

    public void onOperatorPressed(Operator operator) {
    }

    public void OnDemiPressed() {
    }
}
