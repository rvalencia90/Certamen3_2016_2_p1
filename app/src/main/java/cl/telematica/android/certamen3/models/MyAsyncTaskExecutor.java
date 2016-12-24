package cl.telematica.android.certamen3.models;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.util.concurrent.ExecutionException;

/**
 * Created by franciscocabezas on 11/18/16.
 */

public class MyAsyncTaskExecutor {

    private RecyclerView.Adapter mAdapter;

    private static MyAsyncTaskExecutor instance;

    public static MyAsyncTaskExecutor getInstance() {
        if(instance == null) {
            instance = new MyAsyncTaskExecutor();
        }
        return instance;
    }

    public String executeMyAsynctask() {
        String asd = null;

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            String resultado;

            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {
                resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/582eea8b2600007b0c65f068", 15000);
                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    System.out.println(result);

                }
            }
        };

        try {
            asd = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return asd;
    }

}
