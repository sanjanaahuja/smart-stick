package com.example.smartstick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login_button,register_button;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);
        register_button = findViewById(R.id.register_button);
        firebaseAuth = FirebaseAuth.getInstance();

        login_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // extract the data from form
                String email =  username.getText().toString();
                String passwrd = password.getText().toString();
                if(email.isEmpty()){
                    username.setError("Email is Missing");
                    return;

                }

                if(passwrd.isEmpty()){
                    username.setError("Password is Missing");
                    return;

                }
                //Data is filled now we will login the user
                firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Login is Successful
                        startActivity(new Intent(getApplicationContext(),homepage.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Login is failed
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),homepage.class));
            finish();
        }
    }
}
