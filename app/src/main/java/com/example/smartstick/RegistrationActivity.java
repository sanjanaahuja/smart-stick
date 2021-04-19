package com.example.smartstick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText email_id,full_name,password,confpassword,contact_no;
    Button registerbtn;

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

                // data is validated now continue the registration process
                

            }
        });

    }
}
