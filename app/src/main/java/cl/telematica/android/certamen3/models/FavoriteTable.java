package cl.telematica.android.certamen3.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by telusm on 23-12-2016.
 */

public class FavoriteTable extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "favorite";
    private static final String TABLE_FAVORITE = "feed";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_LINK = "link";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PUBLISHERDATE = "publishedDate";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_IMAGE = "image";

    public FavoriteTable(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RANKING_TABLE = "CREATE TABLE " + TABLE_FAVORITE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
                + KEY_LINK + " TEXT," + KEY_AUTHOR + " TEXT,"
                + KEY_PUBLISHERDATE + " TEXT," + KEY_CONTENT + " TEXT,"
                + KEY_IMAGE + " TEXT" +  ")";
        db.execSQL(CREATE_RANKING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE);
        onCreate(db);
    }

    public void create(Feed feed){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_TITLE, feed.getTitle());
        values.put(KEY_ID, feed.getId());
        values.put(KEY_LINK, feed.getLink());
        values.put(KEY_AUTHOR, feed.getAuthor());
        values.put(KEY_PUBLISHERDATE, feed.getPublishedDate());
        values.put(KEY_CONTENT, feed.getContent());
        values.put(KEY_IMAGE, feed.getImage());

        //insert
        db.insert(TABLE_FAVORITE,null,values);
        db.close();
    }

    public List<Feed> getList(){
        List<Feed> nameList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVORITE+ " ORDER BY "+ KEY_ID+ " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Feed feed = new Feed();
                feed.setId(cursor.getInt(0));
                feed.setTitle(cursor.getString(1));
                feed.setLink(cursor.getString(2));
                feed.setAuthor(cursor.getString(3));
                feed.setPublishedDate(cursor.getString(4));
                feed.setContent(cursor.getString(5));
                feed.setImage(cursor.getString(6));
                feed.setFavorite(true);

                nameList.add(feed);
            } while (cursor.moveToNext());
        }

        // return feed list
        return nameList;

    }

    public void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITE,KEY_ID + "=" + id,null);
        db.close();
    }
    public boolean checkIfExists(int id){
        String selectQuery = "SELECT * FROM " + TABLE_FAVORITE+ " WHERE "+ KEY_ID + "=" + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() != 0)
            return true;
        else return false;
    }
}

