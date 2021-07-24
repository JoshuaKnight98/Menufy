package com.example.menufy.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.menufy.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MailFragment extends Fragment implements View.OnClickListener{

    private FloatingActionButton fabMail;
    private TextView textViewMail;
    private EditText editTextMail;

    public MailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mail, container, false);
        textViewMail = view.findViewById(R.id.textViewMail);
        fabMail = view.findViewById(R.id.fabMail);
        fabMail.setOnClickListener(this::onClick);

        return view;
    }

    private void showAlertForAddMail(String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if(title != null) builder.setTitle(title);
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_mail, null);
        editTextMail = viewInflated.findViewById(R.id.editTextMail);
        builder.setView(viewInflated);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String mail = editTextMail.getText().toString();
                textViewMail.setText(mail);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        showAlertForAddMail("Type your mail");
    }
}