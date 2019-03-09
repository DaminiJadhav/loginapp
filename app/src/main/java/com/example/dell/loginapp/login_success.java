package com.example.dell.loginapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login_success extends AppCompatActivity {
    Button btn;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

          btn=findViewById(R.id.button2);
          btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Toast.makeText(login_success.this, "Welcome", Toast.LENGTH_SHORT).show();

              }
          });

    }
}
