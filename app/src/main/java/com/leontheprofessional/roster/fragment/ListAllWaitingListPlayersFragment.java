package com.leontheprofessional.roster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.leontheprofessional.roster.R;
import com.leontheprofessional.roster.adapter.PlayersWaitingListViewAdapter;

/**
 * Created by yangl on 7/5/2016.
 */
public class ListAllWaitingListPlayersFragment extends Fragment {
    private static final String LOG_TAG = ListAllWaitingListPlayersFragment.class.getSimpleName();

    private ListView listViewWaitingList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v(LOG_TAG, "ListAllWaitingListPlayersFragment injected.");

        View view = inflater.inflate(R.layout.listview_players_waiting_list, null);
        listViewWaitingList = (ListView) view.findViewById(R.id.lv_players_waitinglist);
        PlayersWaitingListViewAdapter playersWaitingListViewAdapter = new PlayersWaitingListViewAdapter(getContext());
        listViewWaitingList.setAdapter(playersWaitingListViewAdapter);

        return view;
    }


}
