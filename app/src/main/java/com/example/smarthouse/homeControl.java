package com.example.smarthouse;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class homeControl extends AppCompatActivity
{
    TextView temperature; // id: btn7a_homeControl
    Button lightOn; // id: @+id/btn3a_homeControl
    Button lightOff; // id: @+id/btn3b_homeControl

    //Initializing the Database
    DatabaseReference myData = FirebaseDatabase.getInstance().getReference(); // gets us a reference to the root of the Firebase JSON tree
    DatabaseReference mConditionRef = myData.child("temperature");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_control);

        //initializing the UI elements
        temperature = (TextView) findViewById(R.id.btn7a_homeControl);
        lightOn = (Button)findViewById(R.id.btn3a_homeControl);
        lightOff = (Button)findViewById(R.id.btn3b_homeControl);
    }

    protected void onStart() { //value listener
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                temperature.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        lightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                mConditionRef.setValue("hot"); //sets the value in the temp textbox
            }
        });


        lightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                mConditionRef.setValue("cold"); //sets the value in the temp textbox
            }
        });
    }


}

