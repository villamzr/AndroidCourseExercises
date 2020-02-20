package com.application.playerapp;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.playerapp.PlayerFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyPlayerRecyclerViewAdapter extends RecyclerView.Adapter<MyPlayerRecyclerViewAdapter.ViewHolder> {

    private final List<Player> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyPlayerRecyclerViewAdapter(List<Player> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_player, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.playerItem = mValues.get(position);
        holder.textViewPlayerName.setText(holder.playerItem.getName());
        holder.textViewPlayerTeam.setText(holder.playerItem.getTeam());
        holder.textViewPlayerOld.setText(holder.playerItem.getOld());
        Picasso.get().load(holder.playerItem.getPhoto()).into(holder.imageViewPlayerPhoto);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.playerItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewPlayerName;
        public final TextView textViewPlayerTeam;
        public final TextView textViewPlayerOld;
        public final ImageView imageViewPlayerPhoto;
        public Player playerItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewPlayerName = view.findViewById(R.id.textViewPlayerName);
            textViewPlayerTeam = view.findViewById(R.id.textViewPlayerTeam);
            textViewPlayerOld = view.findViewById(R.id.textViewPlayerOld);
            imageViewPlayerPhoto = view.findViewById(R.id.imageViewPlayerPhoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewPlayerName.getText() + "'";
        }
    }
}
