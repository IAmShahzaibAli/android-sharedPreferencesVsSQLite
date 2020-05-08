package com.coronavirus.world.cases.studentdata.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import com.coronavirus.world.cases.studentdata.R;

import java.util.Calendar;

public class timer_activity extends AppCompatActivity {

    TextView textView;
    java.util.Date noteTS;
    String time, date;
    TextView tvTime, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_activity);
       textView = (TextView)findViewById(R.id.txtviewtime);
        textView = (TextView)findViewById(R.id.txtviewdate);




    }
    private void updateTextView() {
        noteTS = Calendar.getInstance().getTime();

        String time = "hh:mm"; // 12:00
        tvTime.setText(DateFormat.format(time, noteTS));

        String date = "dd MMMMM yyyy"; // 01 January 2013
        tvDate.setText(DateFormat.format(date, noteTS));
    }

}
