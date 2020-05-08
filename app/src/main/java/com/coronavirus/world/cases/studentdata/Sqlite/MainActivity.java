package com.coronavirus.world.cases.studentdata.Sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coronavirus.world.cases.studentdata.R;
import com.coronavirus.world.cases.studentdata.SharedPrefrences.Main2Activity;
import com.coronavirus.world.cases.studentdata.timer.timer_activity;

public class MainActivity extends AppCompatActivity {

    Button main2_activity,main4_activity,timer_activity;
    EditText name,age;
    SqliteHelper sqliteHelper;
    int Ageint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingmain2activity();
        sqliteHelper= new SqliteHelper(this);
        timer_activity = (Button)findViewById(R.id.timeractivity);
        bindingValues();
        timer_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.coronavirus.world.cases.studentdata.timer.timer_activity.class);
                startActivity(intent);
            }
        });


    }


    public void bindingmain2activity()
    {
        main2_activity = (Button)findViewById(R.id.main2_activity);
        main2_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }
    public void bindingValues()
    {
        main4_activity = (Button)findViewById(R.id.main4_activity);
        main4_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (EditText)findViewById(R.id.name_sqlite);
                age = (EditText)findViewById(R.id.age_sqlite);
                Ageint = Integer.parseInt(age.getText().toString());
                SQLiteDatabase database = sqliteHelper.getWritableDatabase();
                sqliteHelper.insert(name.getText().toString(),Ageint,database);
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);



            }
        });



    }
}
