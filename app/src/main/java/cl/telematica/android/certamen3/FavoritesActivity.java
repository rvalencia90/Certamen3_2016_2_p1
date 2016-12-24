package cl.telematica.android.certamen3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cl.telematica.android.certamen3.models.Feed;
import cl.telematica.android.certamen3.presenters.FavoritesPresenterImpl;
import cl.telematica.android.certamen3.presenters.FeedPresenterImpl;
import cl.telematica.android.certamen3.views.FavoritesViewImpl;
import cl.telematica.android.certamen3.views.MainActivityViewImpl;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FavoritesViewImpl mView;
    private FavoritesPresenterImpl mPresenter;
    private List<Feed> mFeeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        mPresenter = new FavoritesPresenterImpl(this);
        mView = new FavoritesViewImpl(this);
        mView.createMyRecyclerView();
        mFeeds = mPresenter.getdatos();
        mView.display(mFeeds);

    }
}