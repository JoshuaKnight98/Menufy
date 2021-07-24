package com.example.menufy.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menufy.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InformationFragment extends Fragment implements View.OnClickListener{
    private FloatingActionButton fabInformation;

    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        fabInformation = view.findViewById(R.id.fabInformation);
        fabInformation.setOnClickListener(this::onClick);
        return view;
    }

    @Override
    public void onClick(View v) {
        showAlertForShowingMoreInfo("Show more info", "there is more info about my app");
    }

    private void showAlertForShowingMoreInfo(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if(title != null) builder.setTitle(title);
        if(message != null) builder.setMessage(message);
        builder.setNeutralButton("Ok", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}