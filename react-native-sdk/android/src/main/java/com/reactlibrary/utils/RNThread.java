//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.reactlibrary.utils;

import android.os.AsyncTask;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class RNThread extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public RNThread(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        return constants;
    }

    @ReactMethod
    public void processEPG(
            final String epgJson,
            final Callback errorCallback,
            final Callback successCallback) {
        try {
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("RNThread: processEPG worker Thread details::" +
                            " thread id::" + Thread.currentThread().getId() +
                            " thread priority::" + Thread.currentThread().getPriority() +
                            " thread getStackTrace::" + Thread.currentThread().getStackTrace().toString() +
                            " thread getState::" + Thread.currentThread().getState() +
                            " thread name::" + Thread.currentThread().getName()
                            + " thread getThreadGroup::" + Thread.currentThread().getThreadGroup()
                            + " thread isAlive::" + Thread.currentThread().isAlive()
                            + " thread isInterrupted::" + Thread.currentThread().isInterrupted()
                            + " thread isInterrupted::" + Thread.currentThread().isInterrupted()
                    );
//                    JSONObject jsonObject = null;
                    try {
                        Gson gson = new Gson();
//                        gson.fromJson(epgJson, null);
                        int secToWait = 5 * 1000;
                        System.out.println("Sleeping for 5 secs");
//                        jsonObject = new JSONObject(epgJson);
                        Thread.sleep(secToWait);
                        successCallback.invoke(null, gson.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        errorCallback.invoke(null, e.getMessage());
                    }
                }
            });
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
            errorCallback.invoke(null, e.getMessage());
        }
    }

    @Override
    public String getName() {
        return RNThread.class.getSimpleName();
    }
}
