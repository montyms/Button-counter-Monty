package com.example.michaelmonty.button_counter_monty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button subButton;
    private Button clearButton;
    private TextView countText;
    private View mainActivity;
    private Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        addButton = (Button)findViewById(R.id.add_button);
        subButton = (Button)findViewById(R.id.sub_button);
        clearButton = (Button)findViewById(R.id.clear_button);
        countText = (TextView)findViewById(R.id.countTextView);
        mainActivity = findViewById(R.id.activity_main);
        countText.setText(count.toString());
        countText.setTextSize(25);
        System.out.println(countText.getTextSize());


        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();
                countText.setText(count.toString());
            }
        });

        subButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                remove();
                countText.setText(count.toString());
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearCount();
                countText.setText(count.toString());
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countSave",count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("countSave");
        countText.setText(count.toString());
        if(count >= 0 && count <= 50) {
            countText.setTextSize(countText.getTextSize() + count);
        }
        else {
            countText.setTextSize(25);
        }

    }

    public void add(){
        count = count+1;
        System.out.println(countText.getTextSize());
        if(countText.getTextSize() > 0 && countText.getTextSize() <= 50) {
            countText.setTextSize(50);
            //countText.setTextSize(countText.getTextSize() + 1);
        }
    }

    public void remove(){
        count = count - 1;
        if(count >= 0 && count <= 255) {
            countText.setTextSize(countText.getTextSize() -1);
        }
    }

    public void clearCount(){
        count = 0;
        countText.setTextSize(25);
    }
}
