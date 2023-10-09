package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView scoreTv;
    Button buttonCount;
    EditText nameEt;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTv = findViewById(R.id.scoreTv);
        buttonCount = findViewById(R.id.button_count);
        nameEt = findViewById(R.id.nameEt);

        buttonCount.setOnClickListener(this);

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreTv.setText(String.valueOf(score));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("count", score);
        outState.putString("textValue", scoreTv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        score = saveInstanceState.getInt("count", 0);
        String textValue = saveInstanceState.getString("textValue", "");
        scoreTv.setText(textValue);
    }

    @Override
    public void onClick(View v) {
        //Handle button click if needed
    }
}