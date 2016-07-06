package com.leontheprofessional.roster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangl on 7/5/2016.
 */
public class ListAllWaitingListPlayersFragment extends Fragment {
    private static final String LOG_TAG = ListAllWaitingListPlayersFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v(LOG_TAG, "ListAllWaitingListPlayersFragment injected.");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
