package com.test.foody.listeners;

import com.test.foody.models.Bill;
import com.test.foody.models.Bill;

import java.util.ArrayList;

public interface Load_Bill_Listener {
    void onPre();
    void onEnd(boolean isSucces, ArrayList<Bill> list_Bill_result);
}
