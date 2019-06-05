package com.reactlibrary.utils;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import com.reactlibrary.R;

public class UiUtil {
    public static final int getColor(Context context, int id) {
        return ContextCompat.getColor(context, id);
    }
}
