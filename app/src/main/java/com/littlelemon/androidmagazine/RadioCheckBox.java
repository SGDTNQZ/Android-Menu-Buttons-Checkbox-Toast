package com.littlelemon.androidmagazine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioCheckBox extends AppCompatActivity {

    CheckBox enjoy_chbx, prefer_chbx, hearMore_chbx, satisfied_chbx;
    Button submit_btn;
    RadioButton excellent_rtbn, good_rbtn, okay_rbtn, poor_rbtn;
    String rate, enjoy, prefer, hearMore, satisfied, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_check_box);

        viewDeclaration();
        submitBtnAction();
    }

    public void viewDeclaration(){
        enjoy_chbx = findViewById(R.id.enjoy_chbx);
        prefer_chbx = findViewById(R.id.prefer_chbx);
        hearMore_chbx = findViewById(R.id.hearMore_chbx);
        satisfied_chbx = findViewById(R.id.satisfied_chbx);

        excellent_rtbn = findViewById(R.id.excellent_rbtn);
        good_rbtn = findViewById(R.id.good_rbtn);
        okay_rbtn = findViewById(R.id.okay_rbtn);
        poor_rbtn = findViewById(R.id.poor_rbtn);

        submit_btn = findViewById(R.id.submit_btn);
    }

    public void submitBtnAction(){
        View.OnClickListener submit_btn_action =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(excellent_rtbn.isChecked()){
                    rate = "EXCELLENT";
                } else if (good_rbtn.isChecked()) {
                    rate = "GOOD";
                } else if (okay_rbtn.isChecked()) {
                    rate = "OKAY";
                } else if (poor_rbtn.isChecked()) {
                    rate = "POOR";
                }

                if(enjoy_chbx.isChecked()){
                    enjoy = "YES";
                }else{
                    enjoy = "NO";
                }
                if (prefer_chbx.isChecked()) {
                    prefer = "YES";
                }else {
                    prefer = "NO";
                }
                if (hearMore_chbx.isChecked()) {
                    hearMore = "YES";
                }else {
                    hearMore = "NO";
                }
                if (satisfied_chbx.isChecked()) {
                    satisfied = "YES";
                } else{
                    satisfied = "NO";
                }

                result = "Selected Radio Button is: " + rate + "\n" +
                        "CheckBox Choices: \n" +
                        "I really enjoy this lesson: " + enjoy + "\n" +
                        "I will prefer this lesson also: " + prefer + "\n" +
                        "I would like to hear more from you: " + hearMore + "\n" +
                        "I am satisfied with the content and description : " + satisfied;
                Toast.makeText(RadioCheckBox.this,result,Toast.LENGTH_LONG).show();
            }
        };
        submit_btn.setOnClickListener(submit_btn_action);
    }



}