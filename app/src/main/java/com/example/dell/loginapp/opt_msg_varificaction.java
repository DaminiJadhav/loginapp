package com.example.dell.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class opt_msg_varificaction extends AppCompatActivity {
   Button btn1,btn2;
   EditText etphno,etopt;
   FirebaseAuth auth;
    private String verificationCode;
    String phoneNumber, otp;
PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt_msg_varificaction);


        btn1=findViewById(R.id.btn_generate_otp);
        btn2=findViewById(R.id.btn_sign_in);

        etphno=findViewById(R.id.et_phone_number);
        etopt=findViewById(R.id.et_otp);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber=etphno.getText().toString();
                PhoneAuthProvider.getInstance() .verifyPhoneNumber(phoneNumber,60, TimeUnit.SECONDS,opt_msg_varificaction.this,mCallback);
            }
        });


    }
    private void StartFirebaseLogin()
    {
        auth=FirebaseAuth.getInstance();
        mCallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
        {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(opt_msg_varificaction.this, "Verification completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(opt_msg_varificaction.this, "Verification Failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode=s;
                Toast.makeText(opt_msg_varificaction.this, "Code sent", Toast.LENGTH_SHORT).show();
            }
        };
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp=etopt.getText().toString();
             //   PhoneAuthCredential credential=PhoneAuthCredential.getCredential(verificationCode,opt);
               // SigninWithPhone();
            }
        });




    }
}
