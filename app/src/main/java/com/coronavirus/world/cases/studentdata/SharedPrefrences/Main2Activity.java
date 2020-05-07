package com.coronavirus.world.cases.studentdata.SharedPrefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coronavirus.world.cases.studentdata.R;

import javax.security.auth.PrivateCredentialPermission;

public class Main2Activity extends AppCompatActivity {


    EditText name,age;
    Button next_activity;
    String nameString,ageString;
    int ageint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

bindingValues();
getValues();

    }
    public void bindingValues()
    {
        name = (EditText)findViewById(R.id.name_preferences);
        age = (EditText)findViewById(R.id.age_preferences);
        next_activity = (Button)findViewById(R.id.nextactivity_preferences);

    }
    public void getValues()
    {
        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameString = name.getText().toString();
                ageString = age.getText().toString();
                ageint = Integer.parseInt(ageString);
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",nameString);
                editor.putInt("age",ageint);
                editor.apply();
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);

            }
        });

    }
}
