package com.leontheprofessional.roster.fragment;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.leontheprofessional.roster.R;
import com.leontheprofessional.roster.model.PlayerModel;

/**
 * Created by yangl on 7/5/2016.
 */
public class AddOnePlayerDialogFragment extends DialogFragment {

    private static final String LOG_TAG = AddOnePlayerDialogFragment.class.getSimpleName();

    private TextView tvPlayerNickName;
    private TextView tvPlayerFirstName;
    private TextView tvPlayerLastName;
    private Spinner spinnerGender;
    private Spinner spinnerHeight;
    private Spinner spinnerWeight;

    public static AddOnePlayerDialogFragment newInstance() {
        AddOnePlayerDialogFragment addOnePlayerDialogFragment = new AddOnePlayerDialogFragment();

        return addOnePlayerDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_one_player_dialog_fragment, container, false);

        tvPlayerNickName = (TextView) view.findViewById(R.id.tv_nickname_add_one_player);
        tvPlayerFirstName = (TextView) view.findViewById(R.id.tv_firstname_add_one_player);
        tvPlayerLastName = (TextView) view.findViewById(R.id.tv_lastname_add_one_player);
        spinnerGender = (Spinner) view.findViewById(R.id.spinner_gender_add_one_player);
        spinnerHeight = (Spinner) view.findViewById(R.id.spinner_height_add_one_player);
        spinnerWeight = (Spinner) view.findViewById(R.id.spinner_weight_add_one_player);

        getDialog().setTitle(getResources().getString(R.string.add_one_player));

        Button btnConfirm = (Button) view.findViewById(R.id.btn_confirm_add_one_player);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(LOG_TAG, "btnConfirm clicked!");
                PlayerModel playerModel = new PlayerModel();
                String nickName = (String) tvPlayerNickName.getText();
                playerModel.setNickName(nickName);
                String firstName = (String) tvPlayerFirstName.getText();
                playerModel.setFirstName(firstName);
                String lastName = (String) tvPlayerLastName.getText();
                playerModel.setLastName(lastName);
                String height = spinnerHeight.getSelectedItem().toString();
                playerModel.setHeight(height);
                String weight = spinnerWeight.getSelectedItem().toString();
                playerModel.setWeight(weight);
                String gender = spinnerGender.getSelectedItem().toString();
                playerModel.setGender(gender);
                // todo: database interactions here

            }
        });

        Button btnCancel = (Button) view.findViewById(R.id.btn_cancel_add_one_player);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(getResources().getText(R.string.discard_changes));
                builder.setPositiveButton(getResources().getText(R.string.confirm),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //((DialogFragment) getFragmentManager().findFragmentByTag("add_one_player_dialog")).dismiss();
                                getDialog().dismiss();
                            }
                        }
                ).setNegativeButton(getResources().getText(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // getDialog().dismiss();
                            }
                        });

                builder.show();
            }
        });

        return view;
    }

/*    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Yes")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "No players added", Toast.LENGTH_SHORT).show();
            }
        });

        return super.onCreateDialog(savedInstanceState);
    }*/
}
