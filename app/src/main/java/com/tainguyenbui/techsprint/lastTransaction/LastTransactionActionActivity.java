package com.tainguyenbui.techsprint.lastTransaction;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tainguyenbui.techsprint.R;
import com.tainguyenbui.techsprint.Utils.FragmentConstants;

public class LastTransactionActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_transaction_action);

        if(savedInstanceState == null) {

            Fragment fragment = null;

            String action = getIntent().getExtras().getString("action");


            if(action.equalsIgnoreCase("decline")) {
                fragment = new DeclineLastTransactionFragment();
            } else {
                fragment = new GameFragment();
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    public void changeFragmentTo(String fragmentId) {

        switch (fragmentId) {
            case FragmentConstants.GAME_COMPLETED_FRAGMENT:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new GameCompletedFragment())
                        .commit();
                break;
            default:
                // DO NOTHING
                break;
        }
    }
}
