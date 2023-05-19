package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView MainTxt;
    TextView JustTxt;
    Button PlusBtn;
    Button MinusBtn;
    Button ClearBtn;
    ImageView Coin;
    Button Calc;
    private int a = 0;
    private int g = 1000;
    private int b;
    private String c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainTxt = (TextView) findViewById(R.id.main_txt);
        JustTxt = (TextView) findViewById(R.id.just_txt);
        PlusBtn = (Button) findViewById(R.id.plus_btn);
        MinusBtn = (Button) findViewById(R.id.minus_btn);
        ClearBtn = (Button) findViewById(R.id.clear_btn);
        Coin = (ImageView) findViewById(R.id.coin);
        Calc = (Button) findViewById(R.id.calc);

        PlusBtn.setOnClickListener(clickListener);
        MinusBtn.setOnClickListener(clickListener);
        ClearBtn.setOnClickListener(clickListener);
        Coin.setOnClickListener(clickListener);
    }

    public void startCalc(View v) {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.plus_btn:
                    a++;
                    MainTxt.setText("Шекелей на счету: " + a);
                    break;
                case R.id.minus_btn:
                    a--;
                    MainTxt.setText("Шекелей на счету: " + a);
                    break;
                case R.id.clear_btn:
                    a = 0;
                    MainTxt.setText("Шекелей на счету: " + a);
                    break;
                case R.id.coin:
                    a = g  + a;
                    MainTxt.setText("Шекелей на счету: " + a);
                    break;
            }b = a%10;
            switch (b){
                default:
                    c = " раз";
                    break;
                case 2:
                    c = " раза";
                    break;
                case 3:
                    c = " раза";
                    break;
                case 4:
                    c = " раза";
                    break;
            }
            JustTxt.setText("Вы положили в кошелёк монетки " + a + c);
        }
    };
}