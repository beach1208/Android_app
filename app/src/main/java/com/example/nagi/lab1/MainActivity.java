package com.example.nagi.lab1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int score;
    private HashMap<Integer, String> colorMap = new HashMap<>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private String right_text;
    private String left_text;
    private int left_color;
    private TextView colorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        int whiteColor = Color.argb(255, 255, 255, 255);

        colors.add(Color.BLACK);
        colors.add(Color.BLUE);
        colors.add(Color.CYAN);
        colors.add(whiteColor);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.GRAY);
        colors.add(Color.DKGRAY);
        colors.add(Color.MAGENTA);

        colorMap.put(Color.BLACK, "Black");
        colorMap.put(Color.BLUE, "Blue");
        colorMap.put(Color.CYAN, "Cyan");
        colorMap.put(whiteColor, "White");
        colorMap.put(Color.RED, "Red");
        colorMap.put(Color.GREEN, "Green");
        colorMap.put(Color.YELLOW, "Yellow");
        colorMap.put(Color.GRAY, "Gray");
        colorMap.put(Color.DKGRAY, "Dark Gray");
        colorMap.put(Color.MAGENTA, "Magenta");

        setColor();


    }

    private void setColor() {
        int left = (int) (Math.random() * colors.size());
        left_color = colors.get(left);
        Button leftB = findViewById(R.id.leftButton);
        leftB.setBackgroundColor(left_color);

        int right = (int) (Math.random() * colors.size());
        int right_color = colors.get(right);
        Button rightB = findViewById(R.id.rightButton);
        rightB.setBackgroundColor(right_color);


        left_text = colorMap.get(left_color);
        right_text = colorMap.get(right_color);
        colorView = findViewById(R.id.ColorView);

        String[] textview = {left_text,right_text};
        String choice = textview[(int) (Math.random() * 2)];
        colorView.setText(choice);

//        colorView.setText(new String[]{left_text, right_text}[(int) (Math.random() * 2)]);


    }


    public void buttonClicked(View view) {
        String show = "";
        if(view.getId() == R.id.leftButton) {
            if (left_text.equals(colorView.getText())) {
                score++;
                show = "RIGHT";
            } else {
                score--;
                show = "WRONG";
            }
        }
        if(view.getId() == R.id.rightButton){
            if (right_text.equals(colorView.getText())){
                    score++;
                    show = "RIGHT";
            }else{
                score--;
                show = "WRONG";
            }
        }



        Toast.makeText(this,"YOU ARE " + show ,Toast.LENGTH_SHORT).show();
        TextView scoreview = findViewById(R.id.score);
        scoreview.setText("Score: " + score);
        setColor();


    }





}




