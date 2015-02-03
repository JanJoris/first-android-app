package be.electrodoctor.electroman.common;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import be.electrodoctor.electroman.R;

/**
 * Created by janjoris on 03/02/15.
 */
public class CustomAdapter extends SimpleCursorAdapter {

    public CustomAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = View.inflate(context, R.layout.client_info, null);
        Button btn = (Button)view.findViewById(R.id.Button_Processed);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
