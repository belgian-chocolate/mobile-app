package com.tainguyenbui.techsprint.previousTransactions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.tainguyenbui.techsprint.HomeActivity;
import com.tainguyenbui.techsprint.R;
import com.tainguyenbui.techsprint.Utils.CurrencyUtil;
import com.tainguyenbui.techsprint.Utils.DateUtil;
import com.tainguyenbui.techsprint.Utils.NotificationsConstants;
import com.tainguyenbui.techsprint.Utils.TextUtil;
import com.tainguyenbui.techsprint.Utils.TransactionsUtil;
import com.tainguyenbui.techsprint.model.transaction.Transaction;
import com.tainguyenbui.techsprint.model.transaction.TransactionOverspendResponse;
import com.tainguyenbui.techsprint.model.transaction.TransactionsManager;
import com.tainguyenbui.techsprint.overspend.OverspendingActivity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviousTransactionsFragment extends Fragment implements IPreviousTransactionsCallback {

    private List<Transaction> transactions;
    private CustomAdapter adapter;

    @BindView(R.id.transactions_recycler_view) RecyclerView recyclerView;

    public PreviousTransactionsFragment() {
        // Required empty public constructor
    }

    public static PreviousTransactionsFragment newInstance() {
        PreviousTransactionsFragment fragment = new PreviousTransactionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        transactions = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_previous_transactions, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter(getContext(), transactions);

        recyclerView.setAdapter(adapter);
    }


    public void refreshTransactions(TransactionsManager transactionsManager) {

        transactionsManager.getOnlineTransations(this);
        transactionsManager.getTransactionsOverspend(this);
    }

    @Override
    public void updateTransactions(List<Transaction> transactions) {

        ((HomeActivity)getActivity()).dismissLoadingAnimation();
            adapter.updateTransactions(transactions);
    }

    @Override
    public void processOverspending(TransactionOverspendResponse transactionOverspendResponse) {

        if(transactionOverspendResponse == null) {
            return;
        }

        ((HomeActivity)getActivity()).dismissLoadingAnimation();

        BigDecimal averageDailySpend = transactionOverspendResponse.getAverageDailySpend();
        BigDecimal currentSpend = transactionOverspendResponse.getCurrentSpend();
        if(currentSpend.compareTo(averageDailySpend) < 0) {
            ((HomeActivity)getActivity())
                    .sendNotification(NotificationsConstants.OVERSPEND_ID,
                            "Your spending has increased",
                            "You've spent £150.00 today, £100.00 more than average.",
                            OverspendingActivity.class);
        } else {
            ((HomeActivity)getActivity()).hideLastTransactionContainer();
        }
    }
}

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context context;
    private List<Transaction> transactions;

    public CustomAdapter(Context context, List<Transaction> transactions) {

        this.context = context;
        this.transactions = transactions;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.recyclerview_transactions_item, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        if(position % 3 == 0) {
            holder.container.setBackground(ContextCompat.getDrawable(context, R.drawable.red_linear_gradient_background));
        }

        Transaction transaction = transactions.get(position);

        String merchantLogoUrl = TransactionsUtil.getMerchantLogo(transaction);

        holder.merchantLogoImageView.setImageDrawable(null);

        if(merchantLogoUrl.length() > 5) {
            Picasso.with(context).cancelRequest(holder.merchantLogoImageView);
            Picasso.with(context).load(merchantLogoUrl).transform(new CircleTransform()).into(holder.merchantLogoImageView);
        }

        holder.amountTextView.setText(CurrencyUtil.getAmountInPencesFormattedToPound(transaction.getAmount()));
        holder.merchantTextView.setText(TransactionsUtil.getMerchantName(transaction));
        holder.categoryTextView.setText(TextUtil.formatCategory(transaction.getCategory()));

        Date transactionDate = null;
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.UK);
        try {
            transactionDate = inFormat.parse(transaction.getCreated());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(transactionDate != null) {
            SimpleDateFormat outFormat = new SimpleDateFormat("MMMM", Locale.UK);
            String formattedMonth = outFormat.format(transactionDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(transactionDate);

            String dayOfWeek = DateUtil.getDayOfTheWeek(calendar);
            String dayOfMonth = DateUtil.getDayOfMonth(calendar);
            holder.transactionDateTextView.setText(String.format("%s %s %s",dayOfWeek, dayOfMonth, formattedMonth));
        }

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public void updateTransactions(List<Transaction> transactions) {

        if(transactions != null && transactions.size() > 0) {

            this.transactions.clear();
            this.transactions.addAll(transactions);

            notifyDataSetChanged();
        }
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        ImageView merchantLogoImageView;
        TextView amountTextView;
        TextView merchantTextView;
        TextView transactionDateTextView;
        TextView categoryTextView;


        public CustomViewHolder(View itemView) {

            super(itemView);

            container = (LinearLayout) itemView.findViewById(R.id.reyclerview_transaction_container);
            merchantLogoImageView = (ImageView) itemView.findViewById(R.id.merchant_logo);
            amountTextView = (TextView) itemView.findViewById(R.id.transaction_amount);
            merchantTextView = (TextView) itemView.findViewById(R.id.merchant_name);
            transactionDateTextView = (TextView) itemView.findViewById(R.id.transaction_date);
            categoryTextView = (TextView) itemView.findViewById(R.id.transaction_category);
        }
    }

    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}