package com.tainguyenbui.techsprint.onboarding;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tainguyenbui.techsprint.R;
import com.tainguyenbui.techsprint.Utils.FragmentConstants;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        if (savedInstanceState == null) {

            OnboardingWelcomeFragment welcomeFragment = new OnboardingWelcomeFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments_container, welcomeFragment)
                    .commit();
        }
    }

    public void changeFragmentTo(String fragmentId) {

        Fragment fragment;

        switch (fragmentId) {
            case FragmentConstants.ONBOARDING_SETTINGS_FRAGMENT:
                fragment = new OnboardingSettingsFragment();
                break;
            case FragmentConstants.ONBOARDING_SUMMARY_FRAGMENT:
                fragment = new OnboardingSummaryFragment();
                break;
            default:
                return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
