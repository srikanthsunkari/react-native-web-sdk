
package com.reactlibrary;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.reactlibrary.utils.SampleModule;
import com.reactlibrary.utils.RNThread;
import com.reactlibrary.views.RNEPGCellViewManager;
import com.reactlibrary.views.scroll.ReactHorizontalScrollContainerViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SamplePackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new SampleModule(reactContext), new RNThread(reactContext));
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        ReactHorizontalScrollContainerViewManager reactHorizontalScrollContainerViewManager = new ReactHorizontalScrollContainerViewManager();
        RNEPGCellViewManager RNEPGCellViewManager = new RNEPGCellViewManager();
        return Arrays.<ViewManager>asList(reactHorizontalScrollContainerViewManager, RNEPGCellViewManager);
    }
}

