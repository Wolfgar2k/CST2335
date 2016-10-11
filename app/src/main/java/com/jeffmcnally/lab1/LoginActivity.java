package com.jeffmcnally.lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.app.Activity;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

import static android.app.PendingIntent.getActivity;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Context context = LoginActivity.this;
                EditText email = (EditText) findViewById(R.id.editLoginName);
                SharedPreferences prefs = getSharedPreferences("DefaultEmail", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("DefaultEmail", email.getText().toString());
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);

            }
        });

        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

        EditText email = (EditText) findViewById(R.id.editLoginName);
        SharedPreferences prefs = getSharedPreferences("DefaultEmail", Context.MODE_PRIVATE);
        email.setText( prefs.getString("DefaultEmail", "email@domain.com"));

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}
