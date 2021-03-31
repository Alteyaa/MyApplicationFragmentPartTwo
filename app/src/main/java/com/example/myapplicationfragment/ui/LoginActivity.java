package com.example.myapplicationfragment.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationfragment.R;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnSave;

    private static final Pattern PATTERN_PASSWORD =
            Pattern.compile(
                    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (isValidEmail(email) && PATTERN_PASSWORD.matcher(password).matches()){
                    Intent intent = new Intent(LoginActivity.this,ApplicationActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (!isValidEmail(email)){
                    Toast.makeText(LoginActivity.this, "Ващ email не валидный!!!", Toast.LENGTH_SHORT).show();
                }

                if (!PATTERN_PASSWORD.matcher(password).matches()){
                    Toast.makeText(LoginActivity.this, "Передайтк надежный пароль!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}