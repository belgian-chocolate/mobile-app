package com.tainguyenbui.techsprint.lastTransaction;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.tainguyenbui.techsprint.HomeActivity;
import com.tainguyenbui.techsprint.R;
import com.tainguyenbui.techsprint.Utils.Constants;
import com.tainguyenbui.techsprint.overspend.OverspendFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeclineLastTransactionFragment extends Fragment {

    @BindView(R.id.stats_webView)
    WebView webView;

    public DeclineLastTransactionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_decline_last_transaction, container, false);

        ButterKnife.bind(this, view);


        webView.loadUrl("https://belgian-chocolate.github.io/web-tasks/stats.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(getContext()), "Android");

        return view;
    }

    public class WebAppInterface {

        private Context context;

        public WebAppInterface(Context context) {

            this.context = context;
        }

        @JavascriptInterface
        public void done() {

            Intent intent = new Intent(context, HomeActivity.class);
            intent.putExtra("overspendingAction", Constants.OVERSPENDING_ACTION.DO_NOT_HELP_ME);
            startActivity(intent);

            getActivity().finish();
        }
    }
}
