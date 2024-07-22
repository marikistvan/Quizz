package com.example.quizz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getName();
    private static final String PREF_KEY= RegisterActivity.class.getPackage().toString();
    EditText usernameET;
    EditText emailET;
    EditText passwordET;
    EditText passwordAgainET;

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        //Bundle bundle=getIntent().getExtras();
        //int secret_key=bundle.getInt("SECRET_KEY");
        int secret_key=getIntent().getIntExtra("SECRET_KEY",0);

        if(secret_key != 77){
            finish();
        }

        usernameET=findViewById(R.id.userNameEditText);
        emailET=findViewById(R.id.emailAddressEditText);
        passwordET=findViewById(R.id.passwordEditText);
        passwordAgainET=findViewById(R.id.passwordAgainEditText);

        preferences=getSharedPreferences(PREF_KEY,MODE_PRIVATE);

        String username=preferences.getString("username","");
        String password=preferences.getString("password","");

        usernameET.setText(username);
        passwordET.setText(password);

    }

    public void register(View view) {
        String username=usernameET.getText().toString();
        String email=emailET.getText().toString();
        String password=passwordET.getText().toString();
        String passwordAgain=passwordAgainET.getText().toString();

        if(!password.equals(passwordAgain)){
            //A két jelszó nem egyezik meg, próbáld újra
            Log.e(TAG,"A két jelszó nem egyezik meg!");
        }else{
            //fasza
            Log.i(TAG,"Sikeres regisztráció");
        }
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
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void cancel(View view) {
        finish();
    }
}