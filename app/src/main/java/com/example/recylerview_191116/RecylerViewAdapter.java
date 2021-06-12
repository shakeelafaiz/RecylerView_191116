package com.example.recylerview_191116;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static java.security.AccessController.getContext;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {
    int[] images;
    OnButtonClickListener onButtonClickListener;


    public RecylerViewAdapter(int[] images,OnButtonClickListener onButtonClickListener) {
        this.images = images;
        this.onButtonClickListener= onButtonClickListener;
    }

    @NonNull
    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_in_recylerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,onButtonClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewAdapter.ViewHolder holder, int position) {

        int image_id = images[position];
        holder.images.setImageResource(image_id);

        holder.Msgs.setText("Hi how are you?.. I have..");
        holder.Names.setText("Unknown Contact  " + position);
    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Names;
        TextView Msgs;
        ImageView images;
        Button deleteBtn;
        OnButtonClickListener onButtonClickListener;

        public ViewHolder(@NonNull View itemView, OnButtonClickListener onButtonClickListener) {

            super(itemView);
            this.onButtonClickListener = onButtonClickListener;
            Names = itemView.findViewById(R.id.NameInCardView);
            Msgs = itemView.findViewById(R.id.MsgsInCardView);
            images = itemView.findViewById(R.id.ImageInCardView);
            deleteBtn = itemView.findViewById(R.id.BtnInCardView);

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onButtonClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) ;
                        onButtonClickListener.OnDeleteButtonClick(position);
                    }
                }
            });
        }


        @Override
        public void onClick(View v) {

        }
    }
    public interface OnButtonClickListener{
        public void OnDeleteButtonClick(int position);
    }
}
