package com.example.doan_game.custom_textview;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {

    private static Typeface ChunkTypeface;
    private static Typeface RegularTypeface;
    private static Typeface KaushanTypeface;
    private static Typeface SeasrnTypeface;

    public static Typeface getChunkTypeface(Context context) {

        if(ChunkTypeface == null){
            ChunkTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Chunk Five Print.otf");
        }

        return ChunkTypeface;
    }

    public static Typeface getRegularTypeface(Context context) {
        if(RegularTypeface == null){
            RegularTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/ChunkFive-Regular.otf");
        }
        return RegularTypeface;
    }

    public static Typeface getKaushanTypeface(Context context) {
        if(KaushanTypeface == null){
            KaushanTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/KaushanScript-Regular.otf");
        }
        return KaushanTypeface;
    }

    public static Typeface getSeasrnTypeface(Context context) {
        if(SeasrnTypeface == null){
            SeasrnTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/SEASRN__.ttf");
        }
        return SeasrnTypeface;
    }
}
