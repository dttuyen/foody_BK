package com.test.foody.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.test.foody.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.test.foody.fragment.AccountsFragment;
import com.test.foody.fragment.BillFragment;
import com.test.foody.fragment.CartFragment;
import com.test.foody.fragment.FoodFragment;
import com.test.foody.listeners.Listener_for_BackFragment;
import com.test.foody.models.Bill;
import com.test.foody.utils.Constant_Values;
import com.test.foody.utils.Methods;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout main_layout;
    private Methods methods;
    private static BottomNavigationView bottom_Navigation;
    private Fragment fragment_Food, fragment_Cart, fragment_Bill, fragment_Accounts;
    private boolean doubleBackToExitPressedOnce = false;
    private long m_Backclick = 0;

    @Override
    public void onBackPressed() {
        if(Constant_Values.isDoing_task())
            return;
        if(SystemClock.elapsedRealtime() - m_Backclick > 2000){
            doubleBackToExitPressedOnce = false;
        }
        int backStack_Count = getSupportFragmentManager().getBackStackEntryCount();
        if(backStack_Count == 0 && !doubleBackToExitPressedOnce ){
            doubleBackToExitPressedOnce = true;
            Toast.makeText(MainActivity.this, "Tap again to Exit", Toast.LENGTH_SHORT).show();
            m_Backclick = SystemClock.elapsedRealtime();
        } else {
            m_Backclick = SystemClock.elapsedRealtime();
            super.onBackPressed();
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        methods = new Methods(this);
        AnhXa();
        setUp();
    }

    private void AnhXa(){
        main_layout = (ConstraintLayout) findViewById(R.id.layout_account_logined2);
        bottom_Navigation = (BottomNavigationView) findViewById(R.id.bottom_Navigation);
        bottom_Navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private void setUp(){
        fragment_Food = new FoodFragment();
        fragment_Cart = new CartFragment(new Bill() ,new ArrayList<>(), true, false,
                new Listener_for_BackFragment() {
            @Override
            public void orderBill_Or_BackFragment() {

            }
        });
        fragment_Bill = new BillFragment();
        fragment_Accounts = new AccountsFragment();
        chang_Menu(fragment_Food);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_food:
                    chang_Menu(fragment_Food);
                    return true;
                case R.id.bottom_Cart:
                    chang_Menu(fragment_Cart);
                    return true;
                case R.id.bottom_bill:
                    chang_Menu(fragment_Bill);
                    return true;
                case R.id.bottom_account:
                    chang_Menu(fragment_Accounts);
                    return true;
            }
            return false;
        }
    };

    private void chang_Menu(Fragment fragment){
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            for(int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); ++i){
                getSupportFragmentManager().popBackStack();
            }
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_layout, fragment);
        transaction.commit();
    }

    //Không cho người dùng chuyển tab khi đang thực hiện load
    public static void Navi_disable(){
        for(int i = 0; i < bottom_Navigation.getMenu().size(); ++i){
            bottom_Navigation.getMenu().getItem(i).setEnabled(false);
        }
    }
    //sau khi load xong thực hiện bình thường
    public static void Navi_enable(){
        for(int i = 0; i < bottom_Navigation.getMenu().size(); ++i){
            bottom_Navigation.getMenu().getItem(i).setEnabled(true);
        }
    }

    public static void selecFoodMenu(){
        bottom_Navigation.setSelectedItemId(R.id.bottom_food);
    }
}