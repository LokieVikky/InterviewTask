package com.think42.interview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<String> mItemTexts;
    private ItemClickListener listener;

    public RecyclerAdapter(ItemClickListener listener) {
        this.listener = listener;
        mItemTexts = new ArrayList<>();
        mItemTexts.add("1");
        mItemTexts.add("2");
        mItemTexts.add("3");
        mItemTexts.add("4");
        mItemTexts.add("5");
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_number, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        position = position % mItemTexts.size();
        holder.txtView.setText(mItemTexts.get(position));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtView;
        ImageView imgItem;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.itemText);
            imgItem = itemView.findViewById(R.id.imageView);
            imgItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(getAdapterPosition());
                }
            });
        }
    }
}
