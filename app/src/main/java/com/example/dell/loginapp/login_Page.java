package com.example.dell.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

        public class login_Page extends AppCompatActivity {

            Button btn;
            TextView tv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        btn = findViewById(R.id.loginbutton);
        tv = findViewById(R.id.textview);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(login_Page.this,login_success.class);
                startActivity(i);
            }


        });

    }
}
