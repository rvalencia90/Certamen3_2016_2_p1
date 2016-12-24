package cl.telematica.android.certamen3.presenters;

import java.util.List;

import cl.telematica.android.certamen3.FavoritesActivity;
import cl.telematica.android.certamen3.models.FavoriteTable;
import cl.telematica.android.certamen3.models.Feed;
import cl.telematica.android.certamen3.views.FavoritesViewImpl;

/**
 * Created by telusm on 23-12-2016.
 */

public class FavoritesPresenterImpl {
    FavoritesActivity mView;

    public FavoritesPresenterImpl(FavoritesActivity mView){this.mView =mView;}

    public List<Feed> getdatos(){
        FavoriteTable db = new FavoriteTable(mView.getApplicationContext());
        return db.getList();
    }
}
