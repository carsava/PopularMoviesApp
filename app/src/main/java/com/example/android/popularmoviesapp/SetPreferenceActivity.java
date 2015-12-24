package com.example.android.popularmoviesapp;

import android.app.Activity;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.util.prefs.Preferences;

public class SetPreferenceActivity extends Activity implements Preference.OnPreferenceChangeListener {
	Preferences prefs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();

		bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_order_key)));
	}

	private void bindPreferenceSummaryToValue(Preference preference) {
		// Set the listener to watch for value changes.
		preference.setOnPreferenceChangeListener(this);

		// Trigger the listener immediately with the preference's
		// current value.
		onPreferenceChange(preference,
				PreferenceManager
						.getDefaultSharedPreferences(preference.getContext())
						.getString(preference.getKey(), ""));
	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		String stringValue = newValue.toString();

		if (preference instanceof ListPreference) {
			// For list preferences, look up the correct display value in
			// the preference's 'entries' list (since they have separate labels/values).
			ListPreference listPreference = (ListPreference) preference;
			int prefIndex = listPreference.findIndexOfValue(stringValue);
			if (prefIndex >= 0) {
				preference.setSummary(listPreference.getEntries()[prefIndex]);
			}
		} else {
			// For other preferences, set the summary to the value's simple string representation.
			preference.setSummary(stringValue);
		}
		return true;
	}
}
