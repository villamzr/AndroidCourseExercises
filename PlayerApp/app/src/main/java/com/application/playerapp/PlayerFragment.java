package com.application.playerapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PlayerFragment extends Fragment {
    MyPlayerRecyclerViewAdapter myPlayerRecyclerViewAdapter;
    List<Player> playerList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlayerFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PlayerFragment newInstance(int columnCount) {
        PlayerFragment fragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            playerList = new ArrayList<>();
            playerList.add(new Player("Lionel Messi","Argentina","28", "https://www.gstatic.com/tv/thumb/persons/983712/983712_v9_ba.jpg"));
            playerList.add(new Player("Ronaldinho G.","Brasil","35", "https://www.pasionfutbol.com/__export/1508892277361/sites/pasionlibertadores/img/2017/10/24/ronaldinhosonri3col.jpg_691115875.jpg"));
            playerList.add(new Player("Lampard","Inglaterra","37", "https://i2-prod.dailystar.co.uk/incoming/article15194402.ece/ALTERNATES/s615b/0_Frank-Lampard-England-708516"));
            playerList.add(new Player("J. Rodriguez","Colombia","28", "https://media.gettyimages.com/photos/james-rodriguez-of-colombia-poses-for-a-portrait-during-the-official-picture-id973137958?s=612x612"));
            playerList.add(new Player("Cristiano R.","Portugal","30", "https://s.hs-data.com/bilder/spieler/gross/13029.jpg"));
            playerList.add(new Player("W. Rooney","Inglaterra","40", "https://www.manutd.com/AssetPicker/images/0/0/10/126/687700/Legends-Profile_Wayne-Rooney31523460265900_thumb.jpg"));
            myPlayerRecyclerViewAdapter = new MyPlayerRecyclerViewAdapter(playerList, mListener);
        recyclerView.setAdapter(myPlayerRecyclerViewAdapter);
    }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                                               + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Player item);
    }
}
