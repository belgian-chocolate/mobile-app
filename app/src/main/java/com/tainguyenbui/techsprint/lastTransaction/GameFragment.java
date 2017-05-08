package com.tainguyenbui.techsprint.lastTransaction;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.tainguyenbui.techsprint.R;
import com.tainguyenbui.techsprint.Utils.FragmentConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    @BindView(R.id.game_webView)
    WebView webView;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView.loadUrl("https://belgian-chocolate.github.io/web-tasks/game.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(getContext()), "Android");
    }

    public class WebAppInterface {

        private Context context;

        public WebAppInterface(Context context) {

            this.context = context;
        }

        @JavascriptInterface
        public void gameCompleted() {

            ((LastTransactionActionActivity)getActivity()).changeFragmentTo(FragmentConstants.GAME_COMPLETED_FRAGMENT);
        }
    }
}
