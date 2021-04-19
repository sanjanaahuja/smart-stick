package com.example.smartstick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    private Button Locate_person, button1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Locate_person=findViewById(R.id.Locate_person);
        button1=findViewById(R.id.button1);


        Locate_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,LocatethepersonActivity.class);
                startActivity(intent);
            }
            public void onClick(View v) {
                Intent intent=new Intent(homepage.this,Findthestick.class);
                startActivity(intent);

            }


        });


    }
}
