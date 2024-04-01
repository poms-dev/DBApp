package com.example.dbapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

    Button btnStart, btnRating, btnExit;
    ButtonClickable buttonClickable;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof ButtonClickable) {
            buttonClickable = (ButtonClickable) context;
        }

    }

    @Override
    public void onDetach() {
        buttonClickable = null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        btnStart = view.findViewById(R.id.btnStart);
        btnRating = view.findViewById(R.id.btnRating);
        btnExit = view.findViewById(R.id.btnExit);

        btnStart.setOnClickListener((View v)->{buttonClickable.onButtonClick(Utils.BTN_START);} );
        btnRating.setOnClickListener((View v)->{buttonClickable.onButtonClick(Utils.BTN_RATING);} );
        btnExit.setOnClickListener((View v)->{buttonClickable.onButtonClick(Utils.BTN_EXIT);} );
        return view;
    }
}