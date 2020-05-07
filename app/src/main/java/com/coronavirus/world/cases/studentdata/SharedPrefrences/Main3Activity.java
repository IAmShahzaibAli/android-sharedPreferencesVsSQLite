package com.coronavirus.world.cases.studentdata.SharedPrefrences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.coronavirus.world.cases.studentdata.R;

public class Main3Activity extends AppCompatActivity {


    Button show_data;
    String name;
    int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        show_data = (Button)findViewById(R.id.showdata_preferences);
        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        name = sharedPreferences.getString("name","null");
        age = sharedPreferences.getInt("age",0);
        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main3Activity.this, "Name : "+name+"\n Age : "+age, Toast.LENGTH_LONG).show();






            }
        });








    }
}
