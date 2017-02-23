package com.example.deepak.indiaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static int score = 0;
    private RadioGroup rd1;
    private RadioGroup rd4;
    private RadioGroup rd5;
    private RadioGroup rd6;
    private RadioGroup rd7;
    private RadioGroup rd8;
    private CheckBox aaCheckBox;
    private CheckBox bbCheckBox;
    private CheckBox ccCheckBox;
    private CheckBox ddCheckBox;
    private EditText collectionEditText;

    private static int calcScore(int ans1, int ans2Score, int ans3Score, int ans4Score, int ans5Score,
                                 int ans6Score, int ans7Score, int ans8Score) {
        score = 0;
        score = score + ans1 + ans2Score + ans3Score + ans4Score + ans5Score + ans6Score + ans7Score + ans8Score;
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rd1 = (RadioGroup) findViewById(R.id.rd1Group);
        rd4 = (RadioGroup) findViewById(R.id.rd2Group);
        rd5 = (RadioGroup) findViewById(R.id.rd3Group);
        rd6 = (RadioGroup) findViewById(R.id.rd4Group);
        rd7 = (RadioGroup) findViewById(R.id.rd5Group);
        rd8 = (RadioGroup) findViewById(R.id.rd6Group);


        aaCheckBox = (CheckBox) findViewById(R.id.aa_CheckBox);
        bbCheckBox = (CheckBox) findViewById(R.id.bb_CheckBox);
        ccCheckBox = (CheckBox) findViewById(R.id.cc_CheckBox);
        ddCheckBox = (CheckBox) findViewById(R.id.dd_CheckBox);
        Button Submit = (Button) findViewById(R.id.Submit);
        aaCheckBox.setOnClickListener(this);
        bbCheckBox.setOnClickListener(this);
        ccCheckBox.setOnClickListener(this);
        ddCheckBox.setOnClickListener(this);
        assert Submit != null;
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        Submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                int ans1Score = checkAns1();
                int ans2Score = checkAns2();
                int ans3Score = checkAns3();
                int ans4Score = checkAns4();
                int ans5Score = checkAns5();
                int ans6Score = checkAns6();
                int ans7Score = checkAns7();
                int ans8Score = checkAns8();
                displayQuizScore(calcScore(ans1Score, ans2Score, ans3Score, ans4Score, ans5Score, ans6Score, ans7Score, ans8Score));
            }
        });
    }

    public void displayQuizScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.quizScore);
        scoreView.setText(String.valueOf(score));
    }

    public void resetQuestions(View view) {
        rd1.clearCheck();
        rd4.clearCheck();
        rd5.clearCheck();
        rd6.clearCheck();
        rd7.clearCheck();
        rd8.clearCheck();

        aaCheckBox.setChecked(false);
        bbCheckBox.setChecked(false);
        ccCheckBox.setChecked(false);
        ddCheckBox.setChecked(false);
        collectionEditText.setText("");
        score = 0;
        displayQuizScore(score);
    }

    private int checkAns1() {
        int checkedId = rd1.getCheckedRadioButtonId();
        if (checkedId == R.id.c1_radio_button) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q1 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }

    private int checkAns2() {
        if (aaCheckBox.isChecked() && bbCheckBox.isChecked() && !ccCheckBox.isChecked() && !ddCheckBox.isChecked()) {
            return 1;
        } else {
            Toast.makeText(MainActivity.this, "Ans for Q2 is wrong", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    private int checkAns3() {
        String correctAnswer = "Democracy";
        collectionEditText = (EditText) findViewById(R.id.text_Edittext);
        String hasCollection = collectionEditText.getText().toString();
        Log.v("Mainactivity", correctAnswer);
        Log.v("Mainactivity", hasCollection);
        if (hasCollection.equals(correctAnswer)) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q3 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }

    private int checkAns4() {
        int checkedId1 = rd4.getCheckedRadioButtonId();
        if (checkedId1 == R.id.d_radio_button) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q4 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }

    private int checkAns5() {
        int checkedId = rd5.getCheckedRadioButtonId();
        if (checkedId == R.id.a2_radio_button) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q5 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }

    private int checkAns6() {
        int checkedId = rd6.getCheckedRadioButtonId();
        if (checkedId == R.id.c3_radio_button) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q6 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }

    private int checkAns7() {
        int checkedId = rd7.getCheckedRadioButtonId();
        if (checkedId == R.id.b4_radio_button) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q7 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }

    private int checkAns8() {
        int checkedId = rd8.getCheckedRadioButtonId();
        if (checkedId == R.id.d5_radio_button) {
            return 1;
        }
        Toast.makeText(MainActivity.this, "Ans for Q8 is wrong",
                Toast.LENGTH_SHORT).show();
        return 0;
    }


    @Override
    public void onClick(View v) {

    }
}