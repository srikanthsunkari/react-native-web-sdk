// Copyright (c) 2004-present, Facebook, Inc.

// This source code is licensed under the MIT license found in the
// LICENSE file in the root directory of this source tree.

package com.reactlibrary.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactlibrary.R;
import com.reactlibrary.utils.UiUtil;

import java.util.logging.Logger;

/**
 * Container of Horizontal scrollViews that supports RTL scrolling.
 */
public class RNEPGCell extends LinearLayout implements View.OnClickListener {

    private final ThemedReactContext context;
    private int width;
    private int height;
    private String text;
    private TextView textView;

    public RNEPGCell(ThemedReactContext context, int width, int height, String text) {
        super(context);
        this.context = context;
        this.init(width, height, text);
    }


    private void init(int width, int height, String text) {
        this.width = width;
        this.height = height;
        this.text = text;
        setFocusable(true);
        setEnabled(true);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
//        this.textView = new ReactTextView(getContext());
//        textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View container = inflater.inflate(R.layout.epg_cell, null);
        textView = container.findViewById(R.id.textView);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        addView(container);
        updateView();
        this.setOnClickListener(this);
    }

    public void updateView() {
        Log.d("RNEPGCell", "UpdateView:: width:: " + width + " height:: " + height + " text:: " + text);
        this.setBackgroundColor(UiUtil.getColor(getContext(), R.color.color_363636));
        textView.setText(text);
        textView.setTextSize(getResources().getDimension(R.dimen.text_size_16));
        textView.setTextColor(UiUtil.getColor(getContext(), android.R.color.white));
        LayoutParams layoutParams = new LayoutParams(this.width != 0 ? this.width : LayoutParams.WRAP_CONTENT, this.height != 0 ? this.height : LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = layoutParams.leftMargin = layoutParams.topMargin = layoutParams.rightMargin = 2;
        this.setLayoutParams(layoutParams);
//        this.textView.setLayoutParams(layoutParams);
    }

    public void setWidth(int width) {
        this.width = width;
        LayoutParams layoutParams = new LayoutParams(this.getLayoutParams().width, this.height);
        this.setLayoutParams(layoutParams);
    }

    public void setHeight(int height) {
        this.height = height;
        LayoutParams layoutParams = new LayoutParams(this.width, this.getLayoutParams().height);
        this.setLayoutParams(layoutParams);
    }

    public void setText(String text) {
        Log.d("RNEPGCell", "text:: " + text);
        this.text = text;
        this.textView.setText(this.text);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        Log.d("RNEPGCell", "gainFocus:: " + gainFocus);
        if (gainFocus) {
            super.setBackgroundColor(UiUtil.getColor(getContext(), android.R.color.white));
            textView.setTextColor(UiUtil.getColor(getContext(), R.color.color_ed3636));
            context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit("onFocus", null);
        } else {
            super.setBackgroundColor(UiUtil.getColor(getContext(), R.color.color_363636));
            textView.setTextColor(UiUtil.getColor(getContext(), android.R.color.white));
            context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit("onBlur", null);
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public void onClick(View v) {
        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onClick", Arguments.createMap());
    }
}
