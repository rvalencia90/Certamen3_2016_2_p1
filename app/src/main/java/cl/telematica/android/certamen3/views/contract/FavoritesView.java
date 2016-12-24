package cl.telematica.android.certamen3.views.contract;

import java.util.List;

import cl.telematica.android.certamen3.models.Feed;

/**
 * Created by telusm on 23-12-2016.
 */

public interface FavoritesView {

    public void display(List<Feed> mList);
    public void createMyRecyclerView();
}
