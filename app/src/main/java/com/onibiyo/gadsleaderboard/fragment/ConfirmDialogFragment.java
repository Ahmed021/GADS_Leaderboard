package com.onibiyo.gadsleaderboard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.onibiyo.gadsleaderboard.R;

public class ConfirmDialogFragment extends DialogFragment {
    private static final String ARGS_MESSAGE = "message";
    private static final int RESULT_OK = 1;

    public ConfirmDialogFragment() {
        Bundle defaultArgs = new Bundle();
        defaultArgs.putString(ARGS_MESSAGE, "");
        setArguments(defaultArgs);
    }

    public static ConfirmDialogFragment newInstance(String message) {
        ConfirmDialogFragment dialog = new ConfirmDialogFragment();
        dialog.getArguments().putString(ARGS_MESSAGE, message);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_confirm, container, false);
        TextView txtMessage = (TextView) view.findViewById(R.id.txtMessage);
        txtMessage.setText(getArguments().getString(ARGS_MESSAGE));
        Button btnOk = view.findViewById(R.id.btn_yes);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickListener listener = (OnClickListener) getActivity();
                if (listener != null) {
                    listener.onConfirm(ConfirmDialogFragment.this);
                }
                dismiss();
            }
        });
        ImageButton btnClose = (ImageButton) view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickListener listener = (OnClickListener) getActivity();
                if (listener != null)
                    listener.onDismiss(ConfirmDialogFragment.this);

                dismiss();
            }
        });

        return view;
    }

    public static interface OnClickListener {
        void onConfirm(ConfirmDialogFragment confirmDialogFragment);
        void onDismiss(ConfirmDialogFragment confirmDialogFragment);
    }
}
