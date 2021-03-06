package com.test.foody.asyntask;

import android.os.AsyncTask;
import android.util.Log;

import com.test.foody.listeners.Load_Reviews_Listener;
import com.test.foody.models.Reviews;
import com.test.foody.utils.JsonUtils;
import com.test.foody.utils.Constant_Values;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.RequestBody;

public class Load_Reviews_Asynctask extends AsyncTask<Void, String, Boolean> {
    private ArrayList<Reviews> list_reviews;
    private Load_Reviews_Listener listener;
    private RequestBody requestBody;

    public Load_Reviews_Asynctask(Load_Reviews_Listener listener, RequestBody requestBody) {
        this.listener = listener;
        this.requestBody = requestBody;
        list_reviews = new ArrayList<>();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onPre();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            String result = JsonUtils.okhttpPost(Constant_Values.URL_BILL_DETAIL_API, requestBody);

            JSONArray jsonArray = new JSONArray(result);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            for(int i = 0; i < jsonArray.length(); ++i){
                JSONObject object = jsonArray.getJSONObject(i);
                Reviews reviews= new Reviews(object.getString("Name_Cus"), dateFormat.parse(object.getString("Time")),
                        (float) object.getDouble("Rate"), object.getString("Reviews"));
                list_reviews.add(reviews);
            }
            return true;
        } catch (Exception e) {
            Log.e("AAA", e.getMessage());
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        listener.onEnd(aBoolean, list_reviews);
    }
}
