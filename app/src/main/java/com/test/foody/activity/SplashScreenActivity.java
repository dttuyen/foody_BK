package com.test.foody.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.test.foody.R;
import com.test.foody.asyntask.Get_Restaurant_Inf_Asynctask;
import com.test.foody.asyntask.Load_Customer_Asynctask;
import com.test.foody.listeners.Check_task_listener;
import com.test.foody.listeners.Load_Customer_Listener;
import com.test.foody.models.Customer;
import com.test.foody.utils.Constant_Values;
import com.test.foody.utils.Methods;

import okhttp3.RequestBody;

public class SplashScreenActivity extends AppCompatActivity {
    private Methods methods;
    private static boolean check = false;

    @Override
    protected void onPause() {
        super.onPause();
        check = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        methods = new Methods(this);
        Constant_Values.save_ID_Cus = getSharedPreferences("save_ID_Cus", Context.MODE_PRIVATE);
        Constant_Values.setIdCus(Constant_Values.save_ID_Cus.getInt("ID_Cus", -1));
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("ID_Res", 1);
                RequestBody requestBody = methods.getRequestBody("method_get_restaurant_data", bundle);
                Get_Restaurant_Inf_Asynctask asynctask = new Get_Restaurant_Inf_Asynctask(requestBody, new Check_task_listener() {
                    @Override
                    public void onPre() {
                        if(Constant_Values.getIdCus() != -1){
                            load_Customer_by_ID(Constant_Values.getIdCus());
                        }
                    }

                    @Override
                    public void onEnd(boolean isSucces, boolean insert_Success) {
                        if(isSucces){
                            startActivity(i);
                            finish();
                        }
                        else
                            Toast.makeText(SplashScreenActivity.this,
                                    "L???i Server", Toast.LENGTH_SHORT).show();
                    }
                });
                if(check){
                    startActivity(i);
                    finish();
                } else {
                    asynctask.execute();
                }
            }
        }, 2000);
    }

    private void load_Customer_by_ID(int ID_Cus){
        Load_Customer_Listener listener1 = new Load_Customer_Listener() {
            @Override
            public void onPre() {
                if (!methods.isNetworkConnected()) {
                    Toast.makeText(SplashScreenActivity.this,
                            "Vui l??ng k???t n???i internet", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onEnd(boolean isSussed, Customer customer) {
                if(isSussed){
                    Constant_Values.setCustomer(customer);
                }
                else
                    Toast.makeText(SplashScreenActivity.this, "L???i Server", Toast.LENGTH_SHORT).show();
            }
        };

        Bundle bundle = new Bundle();
        bundle.putInt("ID_Cus", ID_Cus);
        RequestBody requestBody = methods.getRequestBody("method_get_customer_data_byID", bundle);
        Load_Customer_Asynctask asyntask = new Load_Customer_Asynctask(listener1, requestBody);
        asyntask.execute();
    }
}