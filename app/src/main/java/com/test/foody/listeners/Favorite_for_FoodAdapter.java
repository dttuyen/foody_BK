package com.test.foody.listeners;

import android.widget.ImageView;

import com.test.foody.adapter.FoodAdapter;
import com.test.foody.models.Favorite;
import com.test.foody.models.Foods;

import java.util.ArrayList;

public interface Favorite_for_FoodAdapter {
    //thêm hoặc xóa favorite của người dùng
    void insert_or_del_Fav(Favorite favo, boolean insert_or_del,
                           ImageView imgLike, int source, int ID_Food, boolean value);
}
