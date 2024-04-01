package com.example.dbapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.dbapp.data.FirebaseDataSource;
import com.example.dbapp.model.User;

import java.util.ArrayList;
import java.util.List;


public class RatingFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    UserListAdapter adapter;

    List<User> userList;
    FirebaseDataSource dataSource;


    public RatingFragment() {
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource = new FirebaseDataSource();
        dataSource.initFirebase();
        userList = new ArrayList<>();

        userList = dataSource.readUsers();


        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_rating, container, false);
        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

//        adapter = new UserListAdapter(userList);
//        recyclerView.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    adapter = new UserListAdapter(userList);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);


                }
            },2000);


        return view;
    }
}