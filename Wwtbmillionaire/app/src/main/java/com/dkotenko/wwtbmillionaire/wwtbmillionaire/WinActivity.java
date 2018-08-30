package com.dkotenko.wwtbmillionaire.wwtbmillionaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WinActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
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
