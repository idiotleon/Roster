package com.leontheprofessional.roster.adapter;

import android.content.ContentProvider;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leontheprofessional.roster.R;
import com.leontheprofessional.roster.database.DBContract;
import com.leontheprofessional.roster.database.PlayersContentProvider;

/**
 * Created by Leon on 7/14/2016.
 */
public class PlayersWaitingListViewAdapter extends BaseAdapter {

    private Context context;

    public PlayersWaitingListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        Uri uri = Uri.parse(PlayersContentProvider.PROVIDER_NAME + "/waiting_list");
        int count = 0;
        Cursor resultCursor = context.getContentResolver().query(uri, PlayersContentProvider.PROJECTION_FOR_ALL, null, null, null);
        if(resultCursor.moveToFirst()) count = resultCursor.getCount();
        return count;
    }

    @Override
    public Cursor getItem(int position) {
        Uri uri = Uri.parse(PlayersContentProvider.PROVIDER_NAME + "/waiting_list/" + position);
        Cursor playerObject = context.getContentResolver().query(uri, PlayersContentProvider.PROJECTION_FOR_ALL, null, null, null);
        return playerObject;
    }

    @Override
    public long getItemId(int position) {
        Uri uri = Uri.parse(PlayersContentProvider.PROVIDER_NAME + "/waiting_list/" + position);
        Cursor playerObject = context.getContentResolver().query(uri, PlayersContentProvider.PROJECTION_FOR_ALL, null, null, null);
        int id = playerObject.getInt(playerObject.getColumnIndex(DBContract.COLUMN_PLAYER_ID));
        return id;
    }

    public String getItemUUID(int position) {
        Uri uri = Uri.parse(PlayersContentProvider.PROVIDER_NAME + "/waiting_list/" + position);
        Cursor playerObject = context.getContentResolver().query(uri, PlayersContentProvider.PROJECTION_FOR_ALL, null, null, null);
        String uuid = playerObject.getString(playerObject.getColumnIndex(DBContract.COLUMN_PLAYER_UUID));
        return uuid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.listview_players_item, null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_list_item);
        Cursor playerCursor = getItem(position);
        String columnName = playerCursor.getColumnName(position);
        int columnIndex = playerCursor.getColumnIndex(columnName);
        String playerName = playerCursor.getString(columnIndex);
        textView.setText(playerName);
        return convertView;
    }
}
