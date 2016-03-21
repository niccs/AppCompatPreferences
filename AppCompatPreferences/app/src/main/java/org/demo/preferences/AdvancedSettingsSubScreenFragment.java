package org.demo.preferences;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;


public class AdvancedSettingsSubScreenFragment extends PreferenceFragmentCompat {
    private static final String TAG = AdvancedSettingsSubScreenFragment.class.getName();
    public static final String PAGE_ID = "page_id";

    public static AdvancedSettingsSubScreenFragment newInstance(String pageId) {
        AdvancedSettingsSubScreenFragment f = new AdvancedSettingsSubScreenFragment();
        Bundle args = new Bundle();
        args.putString(PAGE_ID, pageId);
        f.setArguments(args);
        return (f);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // rootKey is the name of preference sub screen key name , here--customPrefKey
        setPreferencesFromResource(R.xml.preferences, rootKey);
        Log.d(TAG, "onCreatePreferences of the sub screen " + rootKey);
    }
}

