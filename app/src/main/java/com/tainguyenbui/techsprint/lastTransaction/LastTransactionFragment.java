package com.tainguyenbui.techsprint.lastTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tainguyenbui.techsprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LastTransactionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LastTransactionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LastTransactionFragment extends Fragment {

    @BindView(R.id.decline_transaction_button)
    Button declineButton;

    @BindView(R.id.approve_transaction_button)
    Button approveButton;

    private OnFragmentInteractionListener mListener;

    public LastTransactionFragment() {
        // Required empty public constructor
    }

    public static LastTransactionFragment newInstance() {
        LastTransactionFragment fragment = new LastTransactionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_last_transaction, container, false);

        ButterKnife.bind(this, view);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();

        declineButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LastTransactionActionActivity.class);
                intent.putExtra("action", "decline");
                startActivity(intent);
            }
        });

        approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LastTransactionActionActivity.class);
                intent.putExtra("action", "approve");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}

