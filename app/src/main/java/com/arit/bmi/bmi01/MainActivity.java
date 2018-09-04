package com.arit.bmi.bmi01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hText) EditText hText;
    @BindView(R.id.wText) EditText wText;
    @BindView(R.id.txtResult) TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCal)
    public void CalBMI(){
        String height = this.hText.getText().toString();
        String weight = this.wText.getText().toString();
        float hNum = Float.parseFloat(height);
        float wNum = Float.parseFloat(weight);
        hNum = hNum/100;
        float bmi = wNum/(hNum*hNum);
        String result = "";
        if(bmi<18.5){
            result="น้ำหนักต่ำกว่าเกณฑ์";
        }else if(bmi<23){
            result="สมส่วน";
        }else if(bmi<25){
            result="น้ำหนักเกิน";
        }else if(bmi<30){
            result="โรคอ้วน";
        }else{
            result="โรคอ้วนอันตราย";
        }

        String bmiResult = Float.toString(bmi);
        bmiResult += "   ";
        bmiResult += result;

        this.txtResult.setText(bmiResult);
    }
}
