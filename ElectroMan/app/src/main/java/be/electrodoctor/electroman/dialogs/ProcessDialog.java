package be.electrodoctor.electroman.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import be.electrodoctor.electroman.R;
import be.electrodoctor.electroman.common.CustomAdapter;
import be.electrodoctor.electroman.database.SQLiteHelper;

/**
 * Created by janjoris on 03/02/15.
 */
public class ProcessDialog extends DialogFragment {

    OnJobProcessed mCallback;

    // Container Activity must implement this interface
    public interface OnJobProcessed {
        public void onJobProcessed();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.process_popup, null);
        builder.setPositiveButton(R.string.process_dialog_process, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText text = (EditText)view.findViewById(R.id.edit_text);
                        Long repairId = getArguments().getLong(CustomAdapter.IdArg);
                        SQLiteHelper dbHelper = new SQLiteHelper(getActivity());
                        int rows = dbHelper.addRepairCommentAndProcess(repairId, text.getText().toString());
                        if(rows == 0)
                            Toast.makeText(getActivity(), R.string.error_unexpected, Toast.LENGTH_SHORT).show();
                        else
                            mCallback.onJobProcessed();
                    }
                })
                .setNegativeButton(R.string.process_dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).setView(view);
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnJobProcessed) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnJobProcessed");
        }
    }
}
