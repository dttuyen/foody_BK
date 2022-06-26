package com.test.foody.listeners;

public interface Get_Next_IDBill_Listener {
    void onPre();
    void onEnd(boolean isSuccess, int next_ID);
}
