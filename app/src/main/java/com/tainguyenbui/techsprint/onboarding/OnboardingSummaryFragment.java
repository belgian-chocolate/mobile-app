package com.tainguyenbui.techsprint.onboarding;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tainguyenbui.techsprint.HomeActivity;
import com.tainguyenbui.techsprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnboardingSummaryFragment extends Fragment {

    @BindView(R.id.complete_setup_button)
    Button completeSetupButton;

    public OnboardingSummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_onboarding_summary, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        completeSetupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);

                getActivity().finish();
            }
        });
    }
}
