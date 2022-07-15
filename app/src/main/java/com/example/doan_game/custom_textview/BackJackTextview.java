package com.example.doan_game.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class BackJackTextview extends AppCompatTextView {
    public BackJackTextview(@NonNull Context context) {
        super(context);
        setFontsTextView();
    }

    public BackJackTextview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView();
    }

    public BackJackTextview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView();
    }
    private void setFontsTextView(){
        Typeface typeface = Utils.getChunkTypeface(getContext());
        setTypeface(typeface);
    }
}
