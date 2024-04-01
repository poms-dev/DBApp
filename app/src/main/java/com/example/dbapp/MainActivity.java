package com.example.dbapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dbapp.data.FirebaseDataSource;
import com.example.dbapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements ButtonClickable{


    FirebaseDataSource dataSource;
    List<User> users;

    FragmentManager fm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
//        startMenu();

    }

    @Override
    public void onButtonClick(String btnText) {

        switch (btnText){
            case "start": Fragment quizFragment = new QuizFragment();
                          navigateToFragment(quizFragment);
                break;

            case "rating":  Fragment ratingFragment = new RatingFragment();
                            navigateToFragment(ratingFragment);
                break;

            case "exit": finish();
            break;
        }

    }

    public void startMenu(){
        MenuFragment menu = new MenuFragment();
        fm.beginTransaction().add(R.id.container,menu)
                .addToBackStack(null)
                .commit();
    }

    public  void navigateToFragment(Fragment fragment){
        fm.beginTransaction().replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
    }
}