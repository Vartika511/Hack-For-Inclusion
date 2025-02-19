package com.example.okane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class IntroductoryActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if(FirebaseAuth.getInstance().getCurrentUser()==null)
                {
                    Intent homeIntent = new Intent(IntroductoryActivity.this, LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
                else
                {
                    startActivity(new Intent(IntroductoryActivity.this,MainActivity.class));
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}