package com.example.smarthouse;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class homeControl extends AppCompatActivity
{

    private DatabaseReference myDatabase;
    private TextView textView1; //humidity
    private TextView textView2; //temp   //may not be private
    //private Switch ledOnOff;
    Button ledStatusON;
    Button ledStatusOFF;


    //Linking the database to firebase
    // may not need?
    FirebaseDatabase database = FirebaseDatabase.getInstance(); //should database be our specific database's name?
    DatabaseReference myRef = database.getReference();

    //Instantiate the readings and pins
    final DatabaseReference ledStatus = myRef.child("led1").child("status");
    final DatabaseReference Humidity = myRef.child("DHT11").child("LxOV6itRV1hggMVrjDi");
    //explanation of initialization:
    //final DatabaseReference myVariableName = myRef.child("main node").child("child of main node ");


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.homeControlBtn6);
        textView2 = findViewById(R.id.homeControlBtn7);
        // led ON/OFF buttons
        ledStatusON = findViewById(R.id.btn1a_homeControl);
        ledStatusOFF = findViewById(R.id.btn1b_homeControl);


        // Initalize database reference
        myDatabase = FirebaseDatabase.getInstance().getReference();

        //Humidity.addValueEventListener(new



        ledStatus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + value);
                textView1.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("file", "Failed to read value.", error.toException());
            }
        });

        ledStatusOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ledStatus.setValue("OFF");
            }
        });

        ledStatusON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ledStatus.setValue("ON");
            }
        });








    }


}
