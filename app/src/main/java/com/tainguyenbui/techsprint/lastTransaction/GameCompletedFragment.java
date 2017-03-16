package com.tainguyenbui.techsprint.lastTransaction;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tainguyenbui.techsprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameCompletedFragment extends Fragment {

    @BindView(R.id.done_button)
    Button doneButton;

    public GameCompletedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_completed, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getActivity().finish();
            }
        });
    }
}
