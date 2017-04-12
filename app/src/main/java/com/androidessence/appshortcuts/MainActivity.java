package com.androidessence.appshortcuts;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDynamicShortcut();
    }

    /**
     * Creates and adds a dynamic shortcut that goes to Google in the browser.
     */
    @TargetApi(25)
    private void addDynamicShortcut() {
        Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));

        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "dynamic_shortcut")
                .setShortLabel(getString(R.string.dynamic_shortcut_short_label))
                .setLongLabel(getString(R.string.dynamic_shortcut_long_label))
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(googleIntent)
                .build();

        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        shortcutManager.addDynamicShortcuts(Collections.singletonList(shortcut));
    }
}
