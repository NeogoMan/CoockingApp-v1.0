package recipe.coking.kitchen.myrecipeapp.Utils;

/**
 * Created by mac on 16/03/16.
 */

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckConnectivity extends AsyncTask<Void, Void, Boolean> {

    @Override
    protected   Boolean doInBackground(Void...params) {
        try {
            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
            urlc.setRequestProperty("User-Agent", "Test");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(3000);
            urlc.connect();
            return (urlc.getResponseCode() == 200);
        }
        catch (IOException e) {

        }
        return false;
    }
}


