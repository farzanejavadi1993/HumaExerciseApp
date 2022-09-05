package com.huma.exerciseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.huma.exerciseapp.R;

public class MenuItemsAdapter extends RecyclerView.Adapter<MenuItemsAdapter.ViewHolder> {

    private String[] localDataSet;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ConstraintLayout menuConstraintLayout;

        public ViewHolder(View view) {

            super(view);
            textView = view.findViewById(R.id.textView);
            menuConstraintLayout = view.findViewById(R.id.menuconstraintLayout);
        }

        public TextView getTextView() {
            return textView;
        }

        public ConstraintLayout getMenuConstraintLayout() {
            return menuConstraintLayout;
        }
    }

    public MenuItemsAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menulayout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextView().setText(localDataSet[position]);
        viewHolder.getMenuConstraintLayout().setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}