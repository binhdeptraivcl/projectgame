package com.example.doan_game.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class KaushanTextview extends AppCompatTextView {
    public KaushanTextview(@NonNull Context context) {
        super(context);
        setFontsTextView();
    }

    public KaushanTextview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView();
    }

    public KaushanTextview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView();
    }
    private void setFontsTextView(){
        Typeface typeface = Utils.getKaushanTypeface(getContext());
        setTypeface(typeface);
    }
}
