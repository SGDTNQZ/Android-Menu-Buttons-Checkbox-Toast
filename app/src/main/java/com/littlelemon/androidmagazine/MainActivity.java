package com.littlelemon.androidmagazine;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView androidPhone_txtv, applePhone_txtv;

    RadioButton creditCard_rbtn, cash_rbtn;

    CheckBox door_cbx, pickUp_cbx;

    Button deliver_btn;

    String payBy, deliverBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewDeclaration_method();
        deliver_btn_method();
    }

    public void viewDeclaration_method(){
        androidPhone_txtv = findViewById(R.id.androidPhone_txtv);
        applePhone_txtv  = findViewById(R.id.applePhone_txtv);

        door_cbx = findViewById(R.id.door_cbx);
        pickUp_cbx = findViewById(R.id.pickUp_cbx);

        deliver_btn = findViewById(R.id.deliver_btn);

        creditCard_rbtn = findViewById(R.id.creditCard_rbtn);
        cash_rbtn = findViewById(R.id.cash_rbtn);


        registerForContextMenu(androidPhone_txtv);
        registerForContextMenu(applePhone_txtv);
    }

    public void deliver_btn_method(){
       View.OnClickListener deliver_btn_action =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(creditCard_rbtn.isChecked()){
                    payBy = "Payment by credit card";
                } else if(cash_rbtn.isChecked()){
                    payBy = "Payment by cash";
                }

                if (door_cbx.isChecked()) {
                    deliverBy = "Delivery method";
                } else if (pickUp_cbx.isChecked()) {
                    deliverBy = "Pick up method";
                }

                String result = "Android: " + androidPhone_txtv.getText() + " " +
                        "iPhone: " + applePhone_txtv.getText() + " " +
                        "Pay by: " + payBy + " " +
                        "Delivery method: " + deliverBy;

                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }
        };

        deliver_btn.setOnClickListener(deliver_btn_action);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == androidPhone_txtv){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.android_menu, menu);
        } else if (v == applePhone_txtv) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.apple_menu, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.samsung_phone)
        {
            androidPhone_txtv.setText("Samsung");
        } else if (item.getItemId() == R.id.huawei_phone) {
            androidPhone_txtv.setText("Huawei");
        } else if (item.getItemId() == R.id.xiaomi_phone) {
            androidPhone_txtv.setText("Xiaomi");
        } else if (item.getItemId() == R.id.mi9_phone) {
            androidPhone_txtv.setText("Mi 9");
        } else if (item.getItemId() == R.id.iphone9_phone) {
            applePhone_txtv.setText("iPhone 9");
        } else if (item.getItemId() == R.id.iphone10_phone) {
            applePhone_txtv.setText("iPhone 10");
        } else if (item.getItemId() == R.id.iphone11_phone) {
            applePhone_txtv.setText("iPhone 11");
        } else if (item.getItemId() == R.id.iphone12_phone) {
            applePhone_txtv.setText("iPhone 12");
        } else if (item.getItemId() == R.id.iphone12pro_phone) {
            applePhone_txtv.setText("iPhone 12 Pro");
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_settings)
        {
            Toast.makeText(this, "Setting menu activated", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_save) {
            Toast.makeText(this, "Save menu activated", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu_cut) {
            Toast.makeText(this, "Cut menu activated", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.menu_exit) {
            Toast.makeText(this, "Exit activated", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}