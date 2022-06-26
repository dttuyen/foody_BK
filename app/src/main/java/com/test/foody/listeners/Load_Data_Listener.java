package com.test.foody.listeners;

import com.test.foody.models.Foods;

import java.util.ArrayList;

public interface Load_Data_Listener {
    void onPre();
    void onEnd(boolean isSussed, ArrayList<Foods> arrayList);
}
