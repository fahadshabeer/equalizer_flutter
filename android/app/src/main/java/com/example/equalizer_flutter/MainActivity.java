package com.example.equalizer_flutter;

import android.content.Intent;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "example.com/channel";
    @Override
    public void configureFlutterEngine( FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if(call.method.equals("change")) {
                                changeScreen();
                            }
                            else {
                                result.notImplemented();
                            }
                        }
                );
    }

    private void changeScreen() {
        Intent myIntent = new Intent(this, equalizer.class);
        startActivity(myIntent);
    }
}
