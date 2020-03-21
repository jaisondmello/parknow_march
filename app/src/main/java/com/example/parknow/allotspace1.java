package com.example.parknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class allotspace1 extends AppCompatActivity {
    EditText mlocation, maddress, mspacename,mspaceavailable;
    Button mallot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DatabaseReference reff;
        final MEMBER member;
        setContentView(R.layout.activity_allotspace1);
        mlocation = findViewById(R.id.alloc);
        maddress = findViewById(R.id.aladd);
        mspacename = findViewById(R.id.alname);
        mspaceavailable = findViewById(R.id.alspace);
        mallot = findViewById(R.id.alnow);
        member=new MEMBER();
        reff = FirebaseDatabase.getInstance().getReference().child("MEMBER");
        mallot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int Spac= Integer.parseInt(mspaceavailable.getText().toString().trim());

              member.setLocation(mlocation.getText().toString().trim());
              member.setAddress(maddress.getText().toString().trim());
              member.setSpace(Spac);
              member.setName(mspacename.getText().toString().trim());

              reff.push().setValue(member);
              Toast.makeText(allotspace1.this,"data inserted",Toast.LENGTH_LONG).show();

            }
        });

    }
}
