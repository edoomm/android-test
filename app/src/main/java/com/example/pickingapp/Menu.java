package com.example.pickingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.welcome);
        String welcome_message = "¡Bienvenido " + message + "!";
        textView.setText(welcome_message);
    }
    public void open_pickup( View view ) {
        Intent intent = new Intent(this, PickUp.class);
        startActivity(intent);
    }

    public void open_configuration( View view ) {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }

    public void open_almacen( View view ) {
        Intent intent = new Intent(this, Storage.class);
        startActivity(intent);
    }
    public void open_help(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

}