package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float height;
    float weight;
    private TextView result;
    private TextView bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculate(View view) {
        // Get user's height
        EditText heightField = (EditText) findViewById(R.id.height_edit_text);



        // get user's weight
        EditText weightField = (EditText) findViewById(R.id.weight_edit_text);



        if ((TextUtils.isEmpty(heightField.getText()))||(TextUtils.isEmpty(weightField.getText())))
        {
            String message="Oops";
            String message1="Invalid Input";
            bmi=(TextView) findViewById(R.id.display_text_view);
            result = (TextView) findViewById(R.id.result_text_view);
            bmi.setText(message);
            result.setText(message1);
        }

        else {
            String value = heightField.getText().toString();
            String value1 = weightField.getText().toString();
            height = Float.parseFloat(value);
            weight = Float.parseFloat(value1);
            //calculate bmi
            float BMI =Calculatebmi();

            bmi=(TextView) findViewById(R.id.display_text_view);
            bmi.setText(Float.toString(BMI));

            //display appropriate message
            String message= summary(BMI);
            result = (TextView) findViewById(R.id.result_text_view);
            result.setText(message);}
        }
    private float Calculatebmi(){
        float BMI;
        BMI=((weight*10000)/(height*height));
        return BMI;
    }
    private String summary(float BMI) {
        String message="";
        if (BMI<18.5) {
            message="Oh no..you'r underweight\nGo EAT!!";
        }
        else if (BMI>=18.5 && BMI<=24.9){
            message="Congratulations!!\n You are absolutely normal";
        }
        else if (BMI>=25 && BMI<=29.9){
            message="You'r overweight..\nWork on your diet!";
        }
        else if (BMI>=30.0 && BMI<=34.9){
            message="Class 1 obesity!";
        }
        else if(BMI>=35 && BMI<=39.9){
            message="Class 2 obesity!";
        }
        else if(BMI>=40.0){
            message="Class 3 obesity!";
        }
        return message;
    }


}
