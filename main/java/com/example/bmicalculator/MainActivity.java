package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.textResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int wt= Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightIn.getText().toString());
                int in =Integer.parseInt( edtHeightIn.getText().toString());

                int totalIn = ft*12+ in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi > 25 ){
                    txtResult.setText("YOu are Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                }else if(bmi <18 ){
                    txtResult.setText("You are underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
                }else{
                    txtResult.setText("Your are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }


            }
        });
    }
}