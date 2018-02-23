package com.example.bibaswann.callbackdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bibaswann on 21/2/18.
 */

public class CustomLayout extends LinearLayout {
    public interface MyOnClickListener {
        void onClick(String inputData);
    }

    private MyOnClickListener myOnClickListener;

    public CustomLayout(Context mContext, MyOnClickListener myOnClickListener) {
        super(mContext);
        initViews(mContext, myOnClickListener);
    }

    public CustomLayout(Context mContext, @Nullable AttributeSet attrs) {
        super(mContext, attrs);
    }

    public void initViews(Context context, final MyOnClickListener myOnClickListener) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_custom, this, true);

        final EditText tvText = findViewById(R.id.etText);
        final Button btnSubmit = findViewById(R.id.btnSubmit);

        this.myOnClickListener = myOnClickListener;

        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myOnClickListener != null) {
                    myOnClickListener.onClick(tvText.getText().toString());
                }
            }
        });
    }
}
