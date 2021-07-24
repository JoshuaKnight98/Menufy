package com.example.menufy.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.menufy.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AlertFragment extends Fragment implements View.OnClickListener{

    private FloatingActionButton fabAlert;
    private TextView textViewAlert;
    private Switch switchAlert;
    boolean statusSwitch = false;

    public AlertFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alert, container, false);

        textViewAlert = view.findViewById(R.id.textViewAlert);
        fabAlert = view.findViewById(R.id.fabAlert);
        fabAlert.setOnClickListener(this::onClick);

        return view;
    }

    private void showAlertForActivatingAlerts(String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if(title != null) builder.setTitle(title);
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_alert, null);
        switchAlert = viewInflated.findViewById(R.id.switchAlerts);
        builder.setView(viewInflated);
        switchAlert.setChecked(statusSwitch);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                statusSwitch = switchAlert.isChecked();
                if(statusSwitch){
                    textViewAlert.setText("Alerts are enabled");
                }else{
                    textViewAlert.setText("Alerts are disabled");
                }

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        showAlertForActivatingAlerts("Activate Alerts");
    }
}