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
    TextView humidity;
    //TextView bpm;

    Button window1Open; // id: @+id/btn1a_homeControl
    Button window1Close; // id: @+id/btn1b_homeControl
    Button window2Open; // id: @+id/btn2a_homeControl
    Button window2Close; // id: @+id/btn2b_homeControl

    Button light1On; // id: btn4a_homeControl
    Button light1Off; // id: btn4b_homeControl
    Button light2On; // id: btn5a_homeControl
    Button light2Off; // id: btn5b_homeControl

    Button elevator1; //id: btn5a_homeControl
    Button elevator2; //id: btn5b_homeControl

    //Initializing the Database
    DatabaseReference myData = FirebaseDatabase.getInstance().getReference(); // gets us a reference to the root of the Firebase JSON tree

    //setting up the nodes
    DatabaseReference mConditionRef = myData.child("temperature"); //"TEST_READING"

    DatabaseReference light_1f = myData.child("f1_light");
    DatabaseReference light_2f = myData.child("f2_light");
    DatabaseReference window1 = myData.child("window1");
    DatabaseReference window2 = myData.child("window2");

    DatabaseReference humidityRead   = myData.child("Humidity");
    DatabaseReference gasRead        = myData.child("gasReading");
    DatabaseReference fanSpeedRead   = myData.child("fanSpeed");
    //DatabaseReference temp = myData.child("temperature");

    //DatabaseReference elevator_g = myData.child("g_elevator");


    //  ~  KEY CONVENTION  ~
    // f1 --> first floor
    // f2 --> second floor
    // g  --> general
    // o  --> outside
    // f1_name --> JSON name
    // name_1f --> JAVA name

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_control);

        //initializing the UI elements
        window1Open = (Button)findViewById(R.id.btn1a_homeControl);
        window1Close = (Button)findViewById(R.id.btn1b_homeControl);
        window2Open = (Button)findViewById(R.id.btn2a_homeControl);
        window2Close = (Button)findViewById(R.id.btn2b_homeControl);

        light1On = (Button)findViewById(R.id.btn4a_homeControl);
        light1Off = (Button)findViewById(R.id.btn4b_homeControl);
        light2On = (Button)findViewById(R.id.btn5a_homeControl);
        light2Off = (Button)findViewById(R.id.btn5b_homeControl);

        elevator1 = (Button)findViewById(R.id.btn7a_homeControl);
        elevator2 = (Button)findViewById(R.id.btn7b_homeControl);

        temperature = (TextView) findViewById(R.id.btn9a_homeControl);

    }

    protected void onStart() { //value listener
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                temperature.setText(text);
                //humidity.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        window1Open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                window1.setValue("open"); //sets the value in the temp textbox
            }
        });

        window1Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                window1.setValue("close"); //sets the value in the temp textbox
            }
        });


        window2Open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                window2.setValue("open"); //sets the value in the temp textbox
            }
        });

        window2Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                window2.setValue("close"); //sets the value in the temp textbox
            }
        });


        light1On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //change the LED object state
             light_1f.setValue("ON");
            }
        });

        light1Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change the LED object state
                light_1f.setValue("OFF");
            }
        });

        light2On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change the LED object state
                light_2f.setValue("ON");
            }
        });

        light2Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change the LED object state
                light_2f.setValue("OFF");
            }
        });
    }


}

