package com.example.estudiante.cliente;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Receptor extends Thread{
    Socket socket;
    //paso2
    OnMessage observer;

    public Receptor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader( new InputStreamReader(is) );




            while(true){
                String line = reader.readLine();
                Log.e("ERROr", line);

                //paso 4: solo funciona cuando observer es diferente de null
                observer.OnRecieved(line);



            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Siempre quiero que este en funcionamiento

    }

    //observable
    //paso1
    public interface  OnMessage{

        public void OnRecieved(String mensaje);
    }

    //paso 3
    public void setObserver(OnMessage observer){
        this.observer =observer;
    }


}
