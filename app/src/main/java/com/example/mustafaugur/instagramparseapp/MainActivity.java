package com.example.mustafaugur.instagramparseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

        ParseUser parseUser = ParseUser.getCurrentUser();

        if (parseUser != null) {
            Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
        }
    }

    public void signIn(View view) {

        ParseUser.logInInBackground(userName.getText().toString(), password.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Hoşgeldin : " + user.getUsername(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void signUp(View view) {

        ParseUser user = new ParseUser();
        user.setUsername(userName.getText().toString());
        user.setPassword(password.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(MainActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

}
