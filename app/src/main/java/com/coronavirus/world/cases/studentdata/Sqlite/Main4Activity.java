package com.coronavirus.world.cases.studentdata.Sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.coronavirus.world.cases.studentdata.R;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {


    SqliteHelper sqliteHelper;
    Button button;
    ArrayList<Model> modelArrayList;
    RecyclerView recyclerView;
    ViewAdapter viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        sqliteHelper= new SqliteHelper(this);
        final SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();
        button = (Button)findViewById(R.id.showdata_sqlite);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        modelArrayList = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = sqLiteDatabase.rawQuery("SELECT NAME,AGE FROM data1",new String[]{});
                if (cursor != null)
                {
                    cursor.moveToFirst();
                }
                do {
                    String name = cursor.getString(0);
                    int age = cursor.getInt(1);
                    modelArrayList.add(new Model(name,age));
                    viewAdapter = new ViewAdapter(modelArrayList,getApplicationContext());
                    recyclerView.setAdapter(viewAdapter);
                    viewAdapter.notifyDataSetChanged();
                }while (cursor.moveToNext());







            }
        });

    }

















}
