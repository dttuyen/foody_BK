package com.test.foody.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.test.foody.R;

import com.test.foody.models.Bill;
import com.test.foody.models.Bill_Details;
import com.test.foody.utils.Methods;
import com.test.foody.utils.Constant_Values;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.test.foody.models.Bill;
import com.test.foody.utils.Methods;

import java.util.ArrayList;
import java.util.Collections;

import okhttp3.RequestBody;

public class BillFragment extends Fragment {
    //xem có bill mới hay k
    private static boolean check_NewBill;

    private RecyclerView recycler_Bill;
    private ProgressBar progressBar_Bill_Frag;
    private static ArrayList<Bill> list_Bill;
    private Methods methods;
    private SwipeRefreshLayout swipRefesh_Bill_Frag;

    public BillFragment() {
        if(list_Bill == null)
            list_Bill = new ArrayList<>();
        check_NewBill = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill, container, false);
        return view;
    }

}
