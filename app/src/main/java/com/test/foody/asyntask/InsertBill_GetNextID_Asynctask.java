package com.test.foody.asyntask;

import android.os.AsyncTask;
import android.util.Log;

import com.test.foody.listeners.Get_Next_IDBill_Listener;
import com.test.foody.models.Reviews;
import com.test.foody.utils.Constant_Values;
import com.test.foody.utils.JsonUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.RequestBody;

public class InsertBill_GetNextID_Asynctask extends AsyncTask<Void, String, Boolean> {
    private int next_ID;
    private Get_Next_IDBill_Listener listener;
    private RequestBody requestBody;

    public InsertBill_GetNextID_Asynctask(Get_Next_IDBill_Listener listener, RequestBody requestBody) {
        this.listener = listener;
        this.requestBody = requestBody;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onPre();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            String result = JsonUtils.okhttpPost(Constant_Values.URL_BILL_API, requestBody);

            JSONObject object = new JSONObject(result);
            next_ID = object.getInt("Next_ID");

            return true;
        } catch (Exception e) {
            Log.e("AAA", e.getMessage());
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        listener.onEnd(aBoolean, next_ID);
    }
}
