package com.almanorcomputerrepair.acr;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener bottomSheetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button buttonClose = view.findViewById(R.id.buttonClose);
        Button buttonPhone = view.findViewById(R.id.buttonPhone);
        Button buttonEmail = view.findViewById(R.id.buttonEmail);
        Button buttonWebsite = view.findViewById(R.id.buttonWebsite);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        buttonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                bottomSheetListener.ShowDialog("Phone", "(530) 200-4045", "OK", "Dial", "Copy", "tel:(530) 200-4045");
            }
        });

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                bottomSheetListener.ShowDialog("Email", "nick@acrep.net", "OK", "Email", "Copy", "mailto:nick@acrep.net");
            }
        });

        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://almanorcomputerrepair.com"));
                startActivity(intent);
            }
        });

        return view;
    }

    public interface BottomSheetListener {
        void ShowDialog(String title, String message, String posButton, String negButton, String actionButton, final String location);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            bottomSheetListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement BottomSheetListener");
        }
    }
}
