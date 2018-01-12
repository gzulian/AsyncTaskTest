package com.example.root.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt_cont);
        Tarea task  = new Tarea();
        task.execute(5,20);
    }

    class Tarea extends AsyncTask<Integer,String,String>{

        @Override
        protected String doInBackground(Integer... values) {
            for(int i = values[0]; i<=values[1];i++){
                publishProgress(String.valueOf(i));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
           return "fin";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            txt.setText(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String values) {
            Toast.makeText(getApplicationContext(),"Tarea terminada",Toast.LENGTH_SHORT).show();
            super.onPostExecute(values);
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Comenzando",Toast.LENGTH_SHORT).show();

            super.onPreExecute();
        }
    }
}


