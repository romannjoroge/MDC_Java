package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shr_login_fragment, container, false);

        // Snippet from "Navigate to the next Fragment" section goes here.
        // Get next button, textformlayout and textedittext
        MaterialButton nextButton = view.findViewById(R.id.next_button);
        final TextInputEditText passwordEditText = view.findViewById(R.id.password_edit_text);
        final TextInputLayout passwordTextLayout = view.findViewById(R.id.password_text_input);

        // Set onclicklistener for nextbutton
        nextButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                // Show an error if passwordEditText is not valid
                if(isPasswordValid(passwordEditText.getText()) != true) {
                    // Set error in textlayout
                    passwordTextLayout.setError(getString(R.string.shr_error_password));
                } else {
                    passwordTextLayout.setError(null); // Clear error
                    ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false); // Navigate to the next Fragment
                }
            }
        });

        // Create a listener for every key stroke in passwordEditText
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent keyEvent) {
                // Return true if password is valid
                if(isPasswordValid(passwordEditText.getText())) {
                    passwordTextLayout.setError(null); // Clears the error
                }
                return false;
            }
        });

        return view;
    }


    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private boolean isPasswordValid(@NonNull Editable text) {
        return text.length() >= 8;
    }
}
