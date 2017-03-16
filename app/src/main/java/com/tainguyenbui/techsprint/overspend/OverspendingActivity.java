package com.tainguyenbui.techsprint.overspend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tainguyenbui.techsprint.HomeActivity;
import com.tainguyenbui.techsprint.R;

import butterknife.ButterKnife;

public class OverspendingActivity extends AppCompatActivity {

    private OverspendFragment overspendFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overspending);

        ButterKnife.bind(this);

        if(overspendFragment == null) {
            overspendFragment = new OverspendFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.overspend_fragment_container, overspendFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
