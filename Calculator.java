package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculator extends AppCompatActivity {
    TextView LastTxt;
    EditText ActualEditTxt;
    Button ClearBtn;
    Button PlmnBtn;
    Button PercentBtn;
    Button DivisionBtn;
    Button MultiplyBtn;
    Button MinusBtn;
    Button PlusBtn;
    Button RavnoBtn;
    Boolean isnew = true;
    String operator = "";
    String last_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        LastTxt = findViewById(R.id.last_txt);
        ActualEditTxt = findViewById(R.id.actual_edittxt);
        ClearBtn = findViewById(R.id.clear_btn);
        PlmnBtn = findViewById(R.id.plmn_btn);
        PercentBtn = findViewById(R.id.percent_btn);
        DivisionBtn = findViewById(R.id.division_btn);
        MultiplyBtn = findViewById(R.id.multiply_btn);
        MinusBtn = findViewById(R.id.minus_btn);
        PlusBtn = findViewById(R.id.plus_btn);
        RavnoBtn = findViewById(R.id.ravno_btn);
    }


    public void onNumberClick(View view) {
        if(isnew)
            ActualEditTxt.setText("");
        isnew = false;
        String number = ActualEditTxt.getText().toString();
        switch(view.getId()){
            case R.id.btn1:
                number = number + "1";
                break;
            case R.id.btn2:
                number = number + "2";
                break;
            case R.id.btn3:
                number = number + "3";
                break;
            case R.id.btn4:
                number = number + "4";
                break;
            case R.id.btn5:
                number = number + "5";
                break;
            case R.id.btn6:
                number = number + "6";
                break;
            case R.id.btn7:
                number = number + "7";
                break;
            case R.id.btn8:
                number = number + "8";
                break;
            case R.id.btn9:
                number = number + "9";
                break;
            case R.id.btn0:
                number = number + "0";
                break;


            case R.id.btn_point:
                if(dotishere(number)){

                }else{
                    number = number + ".";
                }
                break;
            case R.id.plmn_btn:
                number = "-" + number;
                break;
        }
        ActualEditTxt.setText(number);
    }

    public void onOperationClick(View view) {
        isnew = true;
        last_number = ActualEditTxt.getText().toString();
        switch (view.getId()){
            case R.id.clear_btn:
                ActualEditTxt.setText("");
                LastTxt.setText("");
                break;
            case R.id.division_btn:
                operator = "÷";
                LastTxt.setText(last_number);
                ActualEditTxt.setText("");
                break;
            case R.id.multiply_btn:
                operator = "×";
                LastTxt.setText(last_number);
                ActualEditTxt.setText("");
                break;
            case R.id.minus_btn:
                operator = "–";
                LastTxt.setText(last_number);
                ActualEditTxt.setText("");
                break;
            case R.id.plus_btn:
                operator = "+";
                LastTxt.setText(last_number);
                ActualEditTxt.setText("");
                break;
        }
    }
    public void onRavnoClick(View view){
        String newnumber = ActualEditTxt.getText().toString();
        Double  result = 0.0;

        switch(operator) {
            case "÷":
                result = Double.parseDouble(last_number) / Double.parseDouble(newnumber);
                break;
            case "×":
                result = Double.parseDouble(last_number) * Double.parseDouble(newnumber);
                break;
            case "–":
                result = Double.parseDouble(last_number) - Double.parseDouble(newnumber);
                break;
            case "+":
                result = Double.parseDouble(last_number) + Double.parseDouble(newnumber);
                break;
        }
        LastTxt.setText(newnumber);
        ActualEditTxt.setText(result.toString());
    }

    public void onPercentClick(View view) {
        if(operator == ""){
            String number = ActualEditTxt.getText().toString();
            double vrem = Double.parseDouble(number) / 100;
            number = vrem + "";
            ActualEditTxt.setText(number);
        }
        else{
            String newnumber = ActualEditTxt.getText().toString();
            Double result = 0.0;
            switch(operator) {
                case "÷":
                    result = Double.parseDouble(last_number) / (Double.parseDouble(last_number) * Double.parseDouble(newnumber)) * 100;
                    break;
                case "×":
                    result = Double.parseDouble(last_number) * Double.parseDouble(newnumber) / 100;
                    break;
                case "–":
                    result = Double.parseDouble(last_number) - (Double.parseDouble(last_number) * Double.parseDouble(newnumber)) / 100;
                    break;
                case "+":
                    result = Double.parseDouble(last_number) + (Double.parseDouble(last_number) * Double.parseDouble(newnumber)) / 100;
                    break;
            }
            ActualEditTxt.setText(result + "");
            operator = "";
        }
    }

    public boolean dotishere(String number){
        if(number.indexOf(".") == -1){
            return false;
        } else{
            return true;
        }
    }
}