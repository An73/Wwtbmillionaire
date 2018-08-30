package com.dkotenko.wwtbmillionaire.wwtbmillionaire;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.dkotenko.wwtbmillionaire.wwtbmillionaire.R.drawable.call_background;

public class GameActivity extends Activity {
    public static final String LEVEL = "level";
    public static final String CALL = "call";
    public static final String CROWD = "crowd";
    public static final String FIFTY = "fifty";
    private boolean call;
    private boolean crowd;
    private boolean fifty;
    private int level;
    private BdQuestions bd;
    private Button mButtonA;
    private Button mButtonB;
    private Button mButtonC;
    private Button mButtonD;

    private int[] levelView = new int[] {R.id.l1, R.id.l2, R.id.l3, R.id.l4, R.id.l5,
            R.id.l6, R.id.l7, R.id.l8, R.id.l9, R.id.l10, R.id.l11, R.id.l12, R.id.l13,
            R.id.l14, R.id.l15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (savedInstanceState != null) {
            level = savedInstanceState.getInt(LEVEL);
            call = savedInstanceState.getBoolean(CALL);
            crowd = savedInstanceState.getBoolean(CROWD);
            fifty = savedInstanceState.getBoolean(FIFTY);
        }
        mButtonA = (Button) findViewById(R.id.button_a);
        mButtonB = (Button) findViewById(R.id.button_b);
        mButtonC = (Button) findViewById(R.id.button_c);
        mButtonD = (Button) findViewById(R.id.button_d);
        TextView textView = (TextView) findViewById(levelView[level]);
        textView.setBackgroundColor(Color.parseColor("#f76f00"));
        textView.setTextColor(Color.BLACK);
        bd = new BdQuestions();
        setQuest(level);
        if (call) {
            ImageButton callAnswer = (ImageButton)findViewById(R.id.iButtonCallToFriend);
            callAnswer.setImageResource(R.drawable.calltofriendpressed);
            callAnswer.setClickable(false);
        }
        if (crowd) {
            ImageButton crowdAnswer = (ImageButton)findViewById(R.id.iButtonCrowd);
            crowdAnswer.setImageResource(R.drawable.crowdpressed);
            crowdAnswer.setClickable(false);
        }
        if (fifty) {
            ImageButton fiftyHelp = (ImageButton)findViewById(R.id.iButtonFifty);
            fiftyHelp.setImageResource(R.drawable.fiftypressed);
            fiftyHelp.setClickable(false);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LEVEL, level);
        outState.putBoolean(CALL, call);
        outState.putBoolean(CROWD, crowd);
        outState.putBoolean(FIFTY, fifty);
    }

    private void setQuest(int level) {
        String variants[] = bd.getVariants(level);
        TextView mTextView = (TextView) findViewById(R.id.questions);

        mTextView.setText(String.valueOf(bd.getQuestion(level)));
        mButtonA.setText("A. " + String.valueOf(variants[0]));
        mButtonB.setText("B. " + String.valueOf(variants[1]));
        mButtonC.setText("C. " + String.valueOf(variants[2]));
        mButtonD.setText("D. " + String.valueOf(variants[3]));
    }

    private void checkAnswer(final int buttonId) {
        Handler handler = new Handler();
        mButtonA.setClickable(false);
        mButtonB.setClickable(false);
        mButtonC.setClickable(false);
        mButtonD.setClickable(false);
        final int answer = bd.getAnswer(level);

        switch (answer) {
            case 0:
                mButtonA.setBackgroundResource(R.drawable.rbutton);
                break;
            case 1:
                mButtonB.setBackgroundResource(R.drawable.rbutton);
                break;
            case 2:
                mButtonC.setBackgroundResource(R.drawable.rbutton);
                break;
            case 3:
                mButtonD.setBackgroundResource(R.drawable.rbutton);
                break;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (level == 14 && answer == buttonId) {
                    finish();
                    win();
                }
                else if (answer == buttonId) {
                    level++;
                    setQuest(level);
                    mButtonA.setBackgroundResource(R.drawable.gbutton);
                    mButtonB.setBackgroundResource(R.drawable.gbutton);
                    mButtonC.setBackgroundResource(R.drawable.gbutton);
                    mButtonD.setBackgroundResource(R.drawable.gbutton);
                    mButtonA.setClickable(true);
                    mButtonB.setClickable(true);
                    mButtonC.setClickable(true);
                    mButtonD.setClickable(true);

                    TextView textView = (TextView) findViewById(levelView[level]);
                    textView.setBackgroundColor(Color.parseColor("#f76f00"));
                    textView.setTextColor(Color.BLACK);
                    TextView textViewBack = (TextView) findViewById(levelView[level - 1]);
                    textViewBack.setBackgroundColor(Color.TRANSPARENT);
                    textViewBack.setTextColor(Color.parseColor("#f76f00"));

                }
                else {
                    finish();
                    lose();
                }
            }
        }, 2000);
    }

    public void lose(){
        Intent intent = new Intent(this, LoseActivity.class);
        intent.putExtra(LEVEL, level);
        startActivity(intent);
    }

    public void win(){
        Intent intent = new Intent(this, WinActivity.class);
        startActivity(intent);
    }

    public void onClickButtonA(View view) {
        Button mButtonA = (Button) findViewById(R.id.button_a);

        mButtonA.setBackgroundResource(R.drawable.gbutton_pressed);
        checkAnswer(0);
    }

    public void onClickButtonB(View view) {
        Button mButtonB = (Button) findViewById(R.id.button_b);

        mButtonB.setBackgroundResource(R.drawable.gbutton_pressed);
        checkAnswer(1);
    }

    public void onClickButtonC(View view) {
        Button mButtonC = (Button) findViewById(R.id.button_c);

        mButtonC.setBackgroundResource(R.drawable.gbutton_pressed);
        checkAnswer(2);
    }

    public void onClickButtonD(View view) {
        Button mButtonD = (Button) findViewById(R.id.button_d);

        mButtonD.setBackgroundResource(R.drawable.gbutton_pressed);
        checkAnswer(3);
    }

    public void onClickButtonCall(View view) {
        ImageButton callAnswer = (ImageButton)findViewById(R.id.iButtonCallToFriend);
        callAnswer.setImageResource(R.drawable.calltofriendpressed);
        callAnswer.setClickable(false);
        call = true;
        DialogCall dialog = new DialogCall(this, bd.getVariants(level)[bd.getAnswer(level)]);
        dialog.show();

    }

    public void onClickButtonCrowd(View view) {
        ImageButton crowdAnswer = (ImageButton)findViewById(R.id.iButtonCrowd);
        crowdAnswer.setImageResource(R.drawable.crowdpressed);
        crowdAnswer.setClickable(false);
        crowd = true;
        DialogCrowd dialogCrowd = new DialogCrowd(this, bd.getAnswer(level));
        dialogCrowd.show();
    }

    public void onClickFifty(View view) {
        ImageButton fiftyHelp = (ImageButton)findViewById(R.id.iButtonFifty);
        fiftyHelp.setImageResource(R.drawable.fiftypressed);
        fiftyHelp.setClickable(false);
        fifty = true;
        switch (bd.getAnswer(level)) {
            case 0:
                mButtonB.setText("");
                mButtonB.setClickable(false);
                mButtonC.setText("");
                mButtonC.setClickable(false);
                break;
            case 1:
                mButtonA.setText("");
                mButtonA.setClickable(false);
                mButtonC.setText("");
                mButtonC.setClickable(false);
                break;
            case 2:
                mButtonA.setText("");
                mButtonA.setClickable(false);
                mButtonD.setText("");
                mButtonD.setClickable(false);
                break;
            case 3:
                mButtonA.setText("");
                mButtonA.setClickable(false);
                mButtonB.setText("");
                mButtonB.setClickable(false);
                break;

        }
    }


}
