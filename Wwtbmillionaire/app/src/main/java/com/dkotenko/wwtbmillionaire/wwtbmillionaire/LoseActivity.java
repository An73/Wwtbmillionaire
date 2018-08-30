package com.dkotenko.wwtbmillionaire.wwtbmillionaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.dkotenko.wwtbmillionaire.wwtbmillionaire.GameActivity.LEVEL;

public class LoseActivity extends Activity {
    private int level;
    private int[] levelView = new int[] {R.string.l1, R.string.l2, R.string.l3, R.string.l4, R.string.l5,
            R.string.l6, R.string.l7, R.string.l8, R.string.l9, R.string.l10, R.string.l11, R.string.l12, R.string.l13,
            R.string.l14, R.string.l15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        level = getIntent().getIntExtra(LEVEL, 0);

        String Slevel = getResources().getString(levelView[level]);
        TextView textView = (TextView) findViewById(R.id.you_level);
        textView.setText("Твой уровень: " + Slevel);
    }

    public void onClickRestart(View view) {
        finish();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onClickExit(View view) {
        finish();
        System.exit(0);
    }
}
