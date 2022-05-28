package com.test.foody.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.test.foody.R;

public class AccountsFragment extends Fragment {
    private static final String btn_INFORMATION = "Your Information";
    private static final String btn_LOG_OUT = "Log Out";
    private static final String btn_SIGN_IN = "Sign In";
    private static final String btn_SIGN_UP = "Sign Up";

    Button btn_SignIn_Account_Frag, btn_SignUp_Account_Frag,
            btn_AboutUs_Account_Login_Frag, btn_TermofU_Account_Frag;
    TextView txtAccount_Frag;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}
