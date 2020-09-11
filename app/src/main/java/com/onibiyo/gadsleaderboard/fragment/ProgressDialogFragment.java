package com.onibiyo.gadsleaderboard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.onibiyo.gadsleaderboard.R;

public class ProgressDialogFragment extends DialogFragment {
    private static final String ARGS_MESSAGE = "message";

    public ProgressDialogFragment() {
        Bundle defaultArgs = new Bundle();
        defaultArgs.putString(ARGS_MESSAGE, "");
        setArguments(defaultArgs);
        setCancelable(false);
    }

    public static ProgressDialogFragment newInstance(String message) {
        ProgressDialogFragment dialogFragment = new ProgressDialogFragment();
        dialogFragment.getArguments().putString(ARGS_MESSAGE, message);
        return dialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_progress, container, false);
        TextView txtMessage = view.findViewById(R.id.txtMessage);
        txtMessage.setText(getArguments().getString(ARGS_MESSAGE));
        return view;
    }
}
