package com.huma.exerciseapp.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huma.exerciseapp.R;
import com.huma.exerciseapp.model.MovieSerial;

import java.util.List;

public class SerialAdapter extends RecyclerView.Adapter<SerialAdapter.ViewHolder> {

    private List<MovieSerial> localDataSet;
    private Activity activity;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;
        private final ConstraintLayout cardConstraintLayout;

        public ViewHolder(View view) {

            super(view);
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
            cardConstraintLayout = view.findViewById(R.id.cardconstraintLayout);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public ConstraintLayout getCardConstraintLayout() {
            return cardConstraintLayout;
        }
    }

    public SerialAdapter(Activity activity,List<MovieSerial> dataSet) {
        localDataSet = dataSet;
        this.activity=activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardlayout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        MovieSerial movieSerial=localDataSet.get(position);
        viewHolder.getTextView().setText(movieSerial.getTitle());

        Glide.with(activity)
                .load(movieSerial.getCardImageUrl())
                .centerCrop()
                .error(R.drawable.huma_logo)
                .into(viewHolder.getImageView());

        viewHolder.getCardConstraintLayout().setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
