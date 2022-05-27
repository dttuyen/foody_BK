package com.test.foody.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.test.foody.models.Bill;
import com.test.foody.models.Bill_Details;
import com.test.foody.utils.Methods;
import com.test.foody.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.RequestBody;

public class CartFragment extends Fragment {
    //ten button
    private static final String btn_ORDER = "ORDER";
    private static final String btn_PICK_ADDRESS = "PICK ADDRESS";
    private static final String btn_TOO_LONG = "TOO LONG";
    private static final String btn_RECEIVED = "RECEIVED";
    private static final String btn_RE_ORDER = "RE-ORDER";
    private static final String btn_FEEDBACK = "FEEDBACK";

    private static final String txtADDRESS_PICK = "Pick your address";


    //list Cart static trong 1 chuong trinh
    private static ArrayList<Bill_Details> list_Bill_details;
    // sẽ lấy bằng vị trí 2 điểm
    private float total = 0f, distance = 0f, shipping_fee = 0f, total_in_address = 0f;
    private Bill bill_holder;
    private static String address_cus = txtADDRESS_PICK;

    private RecyclerView recycler_Cart;
    private TextView txt_Total_Cart_Frag, txtClear_Cart_Frag,
            txtAddress_Cart_Frag, txtDistance_Cart_Frag,
            txtShippingfee_Cart_Frag, txt_Tittle_Cart_Fragment,
            txtDistanceText_Cart_Frag;
    private ImageView img_Back_Cart_Frag;
    private Button btnPick_address_Cart_Frag, btnOrder_Cart_Frag;
    private static Methods methods;

    private ProgressBar progressBar_Cart_frag;

    //true la cho Cart, false la cho bill
    private boolean for_BillorCart, is_done_dill;
    private ArrayList<Bill_Details> list_Bill_details_temp;

    private long mLastClick_Order = 0, mLastClick_PickAddress = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        return view;
    }
}