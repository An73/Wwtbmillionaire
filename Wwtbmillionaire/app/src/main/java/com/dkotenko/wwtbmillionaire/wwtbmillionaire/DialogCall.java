package com.dkotenko.wwtbmillionaire.wwtbmillionaire;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public    class DialogCall extends Dialog implements android.view.View.OnClickListener {
    private Button  ok;
    private String answer;

    public DialogCall(Activity activity, String answer) {
        super(activity);
        this.answer = "Я думаю ответ: " + answer;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_call);
        ok = (Button) findViewById(R.id.button_ok);
        ok.setOnClickListener(this);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView textView = (TextView)findViewById(R.id.answer_call);
        textView.setText(answer);
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
