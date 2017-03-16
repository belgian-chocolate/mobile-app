package com.tainguyenbui.techsprint;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.tainguyenbui.techsprint.lastTransaction.LastTransactionFragment;
import com.tainguyenbui.techsprint.model.transaction.TransactionsManager;
import com.tainguyenbui.techsprint.notifications.NotificationsManager;
import com.tainguyenbui.techsprint.onboarding.OnboardingActivity;
import com.tainguyenbui.techsprint.previousTransactions.PreviousTransactionsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements LastTransactionFragment.OnFragmentInteractionListener {

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout refreshContainer;

    @BindView(R.id.last_transaction_fragment_container)
    FrameLayout lastTransactionContainer;

    @BindView(R.id.divider)
    View divider;

    private LastTransactionFragment lastTransactionFragment;
    private PreviousTransactionsFragment previousTransactionsFragment;
    private TransactionsManager transactionsManager;

    private NotificationsManager notificationsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            String overspendingAction = bundle.getString("overspendingAction");

            if (overspendingAction != null) {
                if (overspendingAction.equalsIgnoreCase("show")) {
                    showLastTransactionContainer();
                }
            }
        }

        if(transactionsManager == null) {

            transactionsManager = new TransactionsManager(this);
        }

        if(lastTransactionFragment == null) {
            lastTransactionFragment = LastTransactionFragment.newInstance();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.last_transaction_fragment_container,lastTransactionFragment)
                .commit();

        if(previousTransactionsFragment == null) {
            previousTransactionsFragment = PreviousTransactionsFragment.newInstance();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.previous_fragment_container, previousTransactionsFragment)
                .commit();

        refreshContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                fetchAccountData();
            }
        });

        refreshContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    @Override
    protected void onResume() {

        super.onResume();

        if(notificationsManager == null) {
            notificationsManager = new NotificationsManager(this, (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE));
        }

        fetchAccountData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, StartupActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void fetchAccountData() {

        previousTransactionsFragment.refreshTransactions(transactionsManager);
    }

    public void dismissLoadingAnimation() {

        refreshContainer.setRefreshing(false);
    }

    public void sendNotification(int id, String title, String message, Class<?> sourceActivityClass) {

        notificationsManager.sendNotification(id, title, message, sourceActivityClass);
    }

    public void showLastTransactionContainer() {

        lastTransactionContainer.setVisibility(View.VISIBLE);
        divider.setVisibility(View.VISIBLE);
    }

    public void hideLastTransactionContainer() {
        lastTransactionContainer.setVisibility(View.GONE);
        divider.setVisibility(View.GONE);
    }
}
