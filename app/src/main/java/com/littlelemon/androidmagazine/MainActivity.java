package com.littlelemon.androidmagazine;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView androidPhone_txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidPhone_txtv = findViewById(R.id.androidPhone_txtv);


        registerForContextMenu(androidPhone_txtv);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
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