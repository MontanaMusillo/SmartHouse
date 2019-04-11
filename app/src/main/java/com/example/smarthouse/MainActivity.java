//Firebase content found via:
// https://www.youtube.com/watch?v=71H9-MRXYOE
//https://medium.com/coinmonks/arduino-to-android-real-time-communication-for-iot-with-firebase-60df579f962
// and various Google Firebase and Android Studio official tutorials and white-pages.

//Firebase Includes and Packages:
package com.example.smarthouse;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Normal Includes, Imports, and Packages:
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;
import android.support.v7.widget.CardView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity
//implements View.OnClickListener
{
    //Linking the database to firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    //Instantiate the readings and pins
    //Example
    //final DatabaseReference ledstatus1 = myRef.child("led1").child("status");

    //Button b1;
    //TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Source:   https://abhiandroid.com/ui/listview
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Button btn1 = findViewById(R.id.btnHomeControls);
        //btn1.setOnClickListener(this); //calling onClick() method


    }

    public void homeControls1(View view)
    {
        //handles the onClick events
        Intent newActivity = new Intent(this, homeControl.class);
        //^^^ directs us to our next activity
        startActivity(newActivity);

    }


    public void heartbeatMonitor1(View view)
    {
        //handles the onClick events
        Intent newActivity = new Intent(this, heartbeatMonitor.class);
        //^^^ directs us to our next activity
        startActivity(newActivity);

    }

    public void fingerprint1(View view)
    {
        //handles the onClick events
        Intent newActivity = new Intent(this, fingerprint.class);
        //^^^ directs us to our next activity
        startActivity(newActivity);

    }


    public void otherSettings1(View view)
    {
        //handles the onClick events
        Intent newActivity = new Intent(this, otherSettings.class);
        //^^^ directs us to our next activity
        startActivity(newActivity);

    }
}