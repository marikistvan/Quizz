package com.example.quizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private static final String PREF_KEY= MainActivity.class.getPackage().toString();
    private static final int SECRET_KEY=77;

    EditText usernameET;
    EditText passwordET;

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usernameET=findViewById(R.id.editTextUsername);
        passwordET=findViewById(R.id.editTextPassowrd);

        preferences=getSharedPreferences(PREF_KEY,MODE_PRIVATE);
    }

    public void login(View view) {
        String username=usernameET.getText().toString();
        String password=passwordET.getText().toString();

        Log.i(TAG,"Bejelentkezett: "+username+", jelszó: "+password);
        //elkérem a szövegét
        //kiírom logba
    }

    public void register(View view) {
        //TODO
        Intent intent=new Intent(this, RegisterActivity.class);
        intent.putExtra("SECRET_KEY",SECRET_KEY);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",usernameET.getText().toString());
        editor.putString("password",passwordET.getText().toString());
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}