package com.example.alizz.pruebahelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ActionButton(View i){
        Button a = (Button) i;
       // a.setTextColor(900)
        if(a.getText()=="HOLA")
            a.setText("CLICK AQUI");
        else
            a.setText("HOLA");
    }
}
