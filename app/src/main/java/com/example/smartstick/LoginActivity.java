package com.example.smartstick;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login_button,register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);
        register_button = findViewById(R.id.register_button);

        login_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // extract the data from form
                String email =  username.getText().toString();

                if(email.isEmpty()){
                    username.setError("Email is required");
                    return;

                }

                if(password.isEmpty()){
                    username.setError("Password is required");
                    return;

                }
            }
        });



    }
}
