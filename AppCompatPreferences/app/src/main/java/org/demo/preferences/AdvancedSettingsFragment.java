package org.demo.preferences;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;


public class AdvancedSettingsFragment extends PreferenceFragmentCompat {
    private static final String TAG = AdvancedSettingsFragment.class.getName();
    public static final String PAGE_ID = "page_id";

    public static AdvancedSettingsFragment newInstance(String pageId) {
        AdvancedSettingsFragment f = new AdvancedSettingsFragment();
        Bundle args = new Bundle();
        args.putString(PAGE_ID, pageId);
        f.setArguments(args);
        return (f);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        final CheckBoxPreference customPreference = (CheckBoxPreference) findPreference("customKey");
        final Preference customSettings = (Preference) findPreference("customPrefKey");
        // First time loading the preference screen, we check the saved settings and enable/disable the custom settings, based on the custom check box
        //get the customSettings value from shared preferences
        if (getCustomSettings(getActivity())) {
            customPreference.setChecked(true);
            customSettings.setEnabled(true);
        } else {
            customPreference.setChecked(false);
            customSettings.setEnabled(false);
        }
        customPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object selectedValue) {
                Log.d(TAG, "Inside on preference change of custom checkbox selection " + selectedValue.getClass());
                if ((Boolean) selectedValue) {
                    customSettings.setEnabled(true);
                }else{
                    customSettings.setEnabled(false);
                }
                return true;
            }
        });
    }
    private boolean getCustomSettings(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("customKey", false);
    }
}


