package cl.telematica.android.certamen3.presenters.contract;

import java.util.List;

import cl.telematica.android.certamen3.models.Feed;

/**
 * Created by telusm on 23-12-2016.
 */

public interface FeedPresenter {
    public List<Feed> getFeeds(String result);
    public List<Feed> getDatos();
}
