package com.example.pickingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class PickUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);

        final int MAX_QUANTITY = 200;

        NumberPicker np = findViewById(R.id.pn);

        String[] values = new String[MAX_QUANTITY];
        for(int i = 0 ; i < values.length ; i++)
            values[i] = Integer.toString(i);

        np.setDisplayedValues(values);
        np.setMinValue(1);
        np.setMaxValue(MAX_QUANTITY - 1);
        np.setValue(1);


        Button scan_button = findViewById(R.id.scan);
        scan_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        try{
                            Intent intent = new Intent();
                            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }



}