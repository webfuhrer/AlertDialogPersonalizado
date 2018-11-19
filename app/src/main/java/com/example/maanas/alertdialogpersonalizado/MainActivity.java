package com.example.maanas.alertdialogpersonalizado;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn_dialog;
TextView tv_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_dialog=findViewById(R.id.btn_dialog);
        tv_nombre=findViewById(R.id.tv_nombre);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sacarDialogo();
            }
        });
    }

    private void sacarDialogo() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        final View v=LayoutInflater.from(this).inflate(R.layout.dialogo, null);

        builder.setView(v);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           EditText et_nombre= v.findViewById(R.id.et_nombre);
           String nombre=et_nombre.getText().toString();

                tv_nombre.setText("Te llamas: "+nombre);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialogo=builder.create();
        dialogo.show();
    }
}
