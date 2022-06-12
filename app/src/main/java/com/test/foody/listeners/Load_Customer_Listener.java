package com.test.foody.listeners;

import com.test.foody.models.Customer;
import com.test.foody.models.Foods;

import java.util.ArrayList;

public interface Load_Customer_Listener {

    void onPre();
    void onEnd(boolean isSussed, Customer customer);
}
