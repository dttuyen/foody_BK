package com.test.foody.listeners;

import com.test.foody.models.Bill_Details;

import java.util.ArrayList;

public interface Load_Bill_Detail_Listener {
    void onPre();
    void onEnd(boolean isSucces, ArrayList<Bill_Details> bill_details_List);
}
