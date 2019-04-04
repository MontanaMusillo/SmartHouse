package com.example.smarthouse;
//Home Control menu ONE

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class homeControl extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_control);
    }
    //Create an Array of Strings
    //These are the text fields in the list view



/*
    ListView simpleList;
    String homeControlList[] =
            {
                    //First HomeControl Sub-Menu
                    "First Floor",
                    "Second Floor",
                    "Elevator",
                    "Other"
            }; */
/*
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_control);

        Intent intent = getIntent();

        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_home_control, R.id.textGrid, homeControlList);
        simpleList.setAdapter(arrayAdapter);

    }
*/


}
