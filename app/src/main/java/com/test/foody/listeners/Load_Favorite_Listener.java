package com.test.foody.listeners;

import com.test.foody.models.Favorite;

import java.util.ArrayList;

public interface Load_Favorite_Listener {
    void onEnd(boolean isDone, ArrayList<Favorite> list_Favorites);
}
