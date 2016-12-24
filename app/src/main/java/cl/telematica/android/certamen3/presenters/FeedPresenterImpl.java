package cl.telematica.android.certamen3.presenters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen3.MainActivity;
import cl.telematica.android.certamen3.models.FavoriteTable;
import cl.telematica.android.certamen3.models.MyAsyncTaskExecutor;
import cl.telematica.android.certamen3.models.Feed;
import cl.telematica.android.certamen3.presenters.contract.FeedPresenter;

/**
 * Created by telusm on 23-12-2016.
 */

public class FeedPresenterImpl implements FeedPresenter {
    MainActivity mainActivity;

    public FeedPresenterImpl(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public List<Feed> getFeeds(String result) {
        List<Feed> feeds = new ArrayList<>();
        try {
            FavoriteTable db = new FavoriteTable(mainActivity.getApplicationContext());
            JSONObject jsonObject = new JSONObject(result);
            JSONObject responseData = jsonObject.getJSONObject("responseData");
            JSONObject feedObj = responseData.getJSONObject("feed");

            JSONArray entries = feedObj.getJSONArray("entries");
            int size = entries.length();
            for(int i = 0; i < size; i++){
                JSONObject entryObj = entries.getJSONObject(i);
                Feed feed = new Feed();

                feed.setId(i);
                feed.setTitle(entryObj.optString("title"));
                feed.setLink(entryObj.optString("link"));
                feed.setAuthor(entryObj.optString("author"));
                feed.setPublishedDate(entryObj.optString("publishedDate"));
                feed.setContent(entryObj.optString("content"));
                feed.setImage(entryObj.optString("image"));

                boolean is_favorite = false;
                is_favorite = db.checkIfExists(i);
                if (is_favorite)
                    feed.setFavorite(true);

                feeds.add(feed);
            }

            return feeds;
        } catch (JSONException e) {
            e.printStackTrace();
            return feeds;
        }
    }

    @Override
    public List<Feed> getDatos() {
        String resultado = MyAsyncTaskExecutor.getInstance().executeMyAsynctask();
        return getFeeds(resultado);
    }
}
