package com.onibiyo.gadsleaderboard.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.onibiyo.gadsleaderboard.R;

public class OkDialogFragment extends DialogFragment {
    private static final String ARGS_MESSAGE = "message";

    public OkDialogFragment() {
        Bundle defaultArgs = new Bundle();
        defaultArgs.putString(ARGS_MESSAGE, "");
        setArguments(defaultArgs);
    }

    public static OkDialogFragment newInstance(String message) {
        OkDialogFragment dialogFragment = new OkDialogFragment();
        dialogFragment.getArguments().putString(ARGS_MESSAGE, message);
        return dialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setMessage(getArguments().getString(ARGS_MESSAGE))
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
