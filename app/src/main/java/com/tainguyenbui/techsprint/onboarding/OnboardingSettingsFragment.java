package com.tainguyenbui.techsprint.onboarding;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tainguyenbui.techsprint.R;
import com.tainguyenbui.techsprint.Utils.FragmentConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnboardingSettingsFragment extends Fragment {

    @BindView(R.id.next_button)
    Button nextButton;

    public OnboardingSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnboardingActivity)getActivity()).changeFragmentTo(FragmentConstants.ONBOARDING_SUMMARY_FRAGMENT);
            }
        });
    }
}
