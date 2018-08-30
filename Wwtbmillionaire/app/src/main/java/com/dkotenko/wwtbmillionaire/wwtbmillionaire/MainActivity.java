package com.dkotenko.wwtbmillionaire.wwtbmillionaire;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartGame(View view) {
        finish();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onExitGame(View view) {
        finish();
        System.exit(0);
    }
}
