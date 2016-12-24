package cl.telematica.android.certamen3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen3.models.Feed;
import cl.telematica.android.certamen3.presenters.FeedPresenterImpl;
import cl.telematica.android.certamen3.views.MainActivityViewImpl;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainActivityViewImpl mView;
    private FeedPresenterImpl mPresenter;
    private List<Feed> mFeeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = new MainActivityViewImpl(this);
        mPresenter = new FeedPresenterImpl(this);

        mView.createMyRecyclerView();
        mFeeds = mPresenter.getDatos();
        mView.display(mFeeds);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            /**
             * You should manage the action to show the favorite items saved by the user
             */
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
