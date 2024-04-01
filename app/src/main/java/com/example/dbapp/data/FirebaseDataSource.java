package com.example.dbapp.data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.dbapp.Utils;
import com.example.dbapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDataSource {

    FirebaseFirestore firestore;

    public void initFirebase(){

       firestore = FirebaseFirestore.getInstance();
    }

    public void writeUser(User user){

        firestore.collection(Utils.USERS).document(String.valueOf(user.hashCode()))
                .set(user).
                addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("Firestore", "DocumentSnapshot successfully written!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Firestore", "Error writing document", e);
                    }
                });


    }

    public List<User> readUsers(){
        List<User> users = new ArrayList<>();

        firestore.collection(Utils.USERS)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Firestore", "GET DATA" + document.getId() + " => " + document.getData());
                                User user =  document.toObject(User.class);
                                users.add(user);
                            }
                        }
                        else {
                            Log.d("Firestore", "Error getting documents: ", task.getException());
                        }

                    }
                });


        return  users;

    }



}
