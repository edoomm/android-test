package com.example.pickingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button scan_button = findViewById(R.id.scan2);
        scan_button.setOnClickListener(this);
    }

    void scanCode () {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(Capture.class);
        integrator.setOrientationLocked(true);
        integrator.setDesiredBarcodeFormats( IntentIntegrator.ALL_CODE_TYPES );
        integrator.setPrompt("Escaneando código de barras");
        integrator.initiateScan();
    }

    @Override
    public void onClick(View view) {
        scanCode();
    }

    @Override
    protected void onActivityResult (int request_code, int result_code, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(request_code, result_code, data);
        if ( result != null ) {
            if (result.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Escaneando resultado");

                builder.setPositiveButton("Escnear de nuevo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scanCode();
                    }
                }).setNegativeButton("Terminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                Toast.makeText(this, "Código no reconocido, intente de nuevo", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(request_code, result_code, data);
        }
    }

    public void ingresar(View view) {
        Intent intent = new Intent(this, Menu.class);
        EditText editText = (EditText) findViewById(R.id.textfield_numero_de_empleado);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}