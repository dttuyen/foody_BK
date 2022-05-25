package com.test.foody.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.test.foody.R;
import com.test.foody.models.Foods;
import com.test.foody.utils.Methods;

import java.util.ArrayList;

import okhttp3.RequestBody;

public class FoodFragment extends Fragment {
    //xem có ng mới đăng nhập hay k
    private static boolean check_NewCus = true;

    private RecyclerView recycler_Food;
    private SearchView search_FoodView;
    private ProgressBar progressBar_load;
    private SwipeRefreshLayout swipRefesh_Food_Frag;
    private Methods methods;
    private static ArrayList<Foods> list_Foods_All;
    private static ArrayList<Bitmap> list_img_slide;
    private boolean check_In_Dev_Fav = false;

    private String search_query = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        return view;
    }
}