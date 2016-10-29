package com.example.computer.recordscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final Button button = (Button) findViewById(R.id.start_record_button);

    public void startRecordScreen(View view){
        // start record screen

    }
}
