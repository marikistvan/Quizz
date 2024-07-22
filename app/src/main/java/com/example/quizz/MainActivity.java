package com.example.quizz;

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

    EditText usernameET;
    EditText passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usernameET=findViewById(R.id.editTextUsername);
        passwordET=findViewById(R.id.editTextPassowrd);
    }

    public void login(View view) {
        String username=usernameET.getText().toString();
        String password=passwordET.getText().toString();

        Log.i(TAG,"Bejelentkezett: "+username+", jelszó: "+password);
        //elkérem a szövegét
        //kiírom logba
    }
}