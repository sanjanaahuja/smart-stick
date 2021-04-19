package com.example.smartstick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText email_id,full_name,password,confpassword,contact_no;
    Button registerbtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationpage);

        email_id = findViewById(R.id.Email_id);
        full_name = findViewById(R.id.full_name);
        password = findViewById(R.id.create_password);
        confpassword = findViewById(R.id.confirm_password);
        contact_no = findViewById(R.id.contact_number);
        registerbtn = findViewById(R.id.signup_button);
        fAuth = FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Extraction and data validation from the register form
                if(full_name.getText().toString().isEmpty()){
                    full_name.setError("Full name is required");
                    return;
                }

                if(email_id.getText().toString().isEmpty()){
                    email_id.setError("Email Id is required");
                    return;
                }

                if(password.getText().toString().isEmpty()){
                    password.setError("Password is required");
                    return;
                }

                if(confpassword.getText().toString().isEmpty()){
                    confpassword.setError("Full name is required");
                    return;
                }

                if(password.equals(confpassword)){
                    confpassword.setError("Password do not match");
                    return;
                }

                if(contact_no.getText().toString().isEmpty()){
                    contact_no.setError("Contact number is required");
                    return;
                }

                // data is validated now
                String email = email_id.getText().toString().trim();
                String passwrd = password.getText().toString();
                fAuth.createUserWithEmailAndPassword(email,passwrd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),RegistrationSuccessActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegistrationActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }
}
