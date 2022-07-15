package com.example.doan_game.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class SeasrnTextview extends AppCompatTextView {
    public SeasrnTextview(@NonNull Context context) {
        super(context);
        setFontsTextView();
    }

    public SeasrnTextview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView();
    }

    public SeasrnTextview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView();
    }
    private void setFontsTextView(){
        Typeface typeface = Utils.getSeasrnTypeface(getContext());
        setTypeface(typeface);
    }
}
