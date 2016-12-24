package cl.telematica.android.certamen3.views;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cl.telematica.android.certamen3.FavoritesActivity;
import cl.telematica.android.certamen3.MainActivity;
import cl.telematica.android.certamen3.R;
import cl.telematica.android.certamen3.adapters.DataAdapter;
import cl.telematica.android.certamen3.models.Feed;
import cl.telematica.android.certamen3.views.contract.FavoritesView;

/**
 * Created by telusm on 23-12-2016.
 */

public class FavoritesViewImpl implements FavoritesView {
    FavoritesActivity mActivity;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    public void display(List<Feed> mList){
        mAdapter = new DataAdapter(mActivity, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public FavoritesViewImpl(FavoritesActivity mainActivity){
        mActivity = mainActivity;
    }

    public void createMyRecyclerView() {
        mRecyclerView = (RecyclerView) mActivity.findViewById(R.id.recyclerView2);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
}
