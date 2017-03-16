package com.tainguyenbui.techsprint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tainguyenbui.techsprint.onboarding.OnboardingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartupActivity extends AppCompatActivity {

    @BindView(R.id.get_started_button)
    Button getStartedButton;

    @BindView(R.id.skip_button)
    Button skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        ButterKnife.bind(this);

        setupButtons();
    }

    private void setupButtons() {

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), OnboardingActivity.class);
                startActivity(intent);
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
