//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.reactlibrary.views;

import android.util.Log;

import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RNEPGCellViewManager extends ViewGroupManager<RNEPGCell> {
    private static final String REACT_CLASS = "EPGCell";
    private static final String PROP_WIDTH = "width";
    private static final String PROP_HEIGHT = "height";
    private static final String PROP_TEXT = "text";
    private static final String PROP_BACKGROUND_COLOR = "backgroundColor";
    private static final String PROP_TEXT_COLOR = "textColor";
    private static final String PROP_TEXT_SIZE = "textSize";
    private static final String PROP_ACTIVE_BACKGROUND_COLOR = "activeBackgroundColor";
    private static final String PROP_ACTIVE_TEXT_COLOR = "activeTextColor";
    private static final String PROP_MARGIN = "margin";
    private static final String PROP_MARGIN_LEFT = "marginLeft";
    private static final String PROP_MARGIN_TOP = "marginTop";
    private static final String PROP_MARGIN_RIGHT = "marginRight";
    private static final String PROP_MARGIN_BOTTOM = "marginBottom";
    private int height;
    private int width;
    private String text;

    public String getName() {
        return REACT_CLASS;
    }

    public RNEPGCell createViewInstance(ThemedReactContext context) {
        return new RNEPGCell(context, width, height, text);
    }

    @ReactProp(name = PROP_WIDTH)
    public void setWidth(final RNEPGCell epgCell, int width) {
        epgCell.setWidth(width);
    }

    @ReactProp(name = PROP_HEIGHT)
    public void setHeight(final RNEPGCell epgCell, int height) {
        epgCell.setHeight(height);
    }

    @ReactProp(name = PROP_TEXT)
    public void setText(final RNEPGCell epgCell, String text) {
        epgCell.setText(text);
    }

    // @Nullable
    // @Override
    // public Object updateLocalData(@Nonnull RNEPGCell view, ReactStylesDiffMap props, ReactStylesDiffMap localData) {
    //     return super.updateLocalData(view, props, localData);
    // }

    @Override
    public void updateExtraData(RNEPGCell root, Object extraData) {
        super.updateExtraData(root, extraData);
    }

    @Override
    protected void onAfterUpdateTransaction(RNEPGCell view) {
        super.onAfterUpdateTransaction(view);
        Log.d("RNEPGCell", "onAfterUpdateTransaction:: ");
        view.updateView();
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        return super.getConstants();
    }
}
