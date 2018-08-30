package com.dkotenko.wwtbmillionaire.wwtbmillionaire;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public    class DialogCrowd extends Dialog implements android.view.View.OnClickListener {
    private Button ok;
    private int answer;

    public DialogCrowd(Activity activity, int answer) {
        super(activity);
        this.answer = answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_crowd);
        ok = (Button) findViewById(R.id.crowd_ok);
        ok.setOnClickListener(this);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView textA = (TextView)findViewById(R.id.crowd_a);
        TextView textB = (TextView)findViewById(R.id.crowd_b);
        TextView textC = (TextView)findViewById(R.id.crowd_c);
        TextView textD = (TextView)findViewById(R.id.crowd_d);

        switch (answer) {
            case 0:
                textA.setText("A: 40%");
                textB.setText("B: 10%");
                textC.setText("C: 30%");
                textD.setText("D: 20%");
                break;
            case 1:
                textA.setText("A: 10%");
                textB.setText("B: 40%");
                textC.setText("C: 30%");
                textD.setText("D: 20%");
                break;
            case 2:
                textA.setText("A: 10%");
                textB.setText("B: 30%");
                textC.setText("C: 40%");
                textD.setText("D: 20%");
                break;
            case 3:
                textA.setText("A: 10%");
                textB.setText("B: 20%");
                textC.setText("C: 30%");
                textD.setText("D: 40%");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
