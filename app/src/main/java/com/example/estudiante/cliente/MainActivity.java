package com.example.estudiante.cliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Receptor.OnMessage {

    Cliente cliente;
    private Button btn_enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         cliente = new Cliente(this);
        cliente.start();

        btn_enviar = findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliente.enviar();
            }
        });
    }

    @Override
    public void OnRecieved(final String mensaje) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //aqui se pone lo que tenga consecuancias graficas

                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
