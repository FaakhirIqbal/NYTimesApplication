package com.fakhar.NYTimeAssignApp.customView;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.fakhar.NYTimeAssignApp.R;

public class NYTimesDialog extends Dialog {
    Context mContext;
    Dialog dialog1;
    public Dialog showDialog() {
        dialog1 = new NYTimesDialog(mContext);
        ProgressBar progressBar = new ProgressBar(mContext);
        dialog1.addContentView(progressBar, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(mContext.getResources().getColor(R.color.colorPrimaryDark), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        try {
            dialog1.show();
        } catch (Exception e) {
            Log.e("Exception" , "" + e.getMessage());
        }
        return dialog1;
    }

    public void dismissDialog()
    {
        if(dialog1!=null && dialog1.isShowing())
        {
            dialog1.dismiss();
        }
    }

    public NYTimesDialog(@NonNull Context context) {
        super(context, R.style.NYTDialog);
        this.mContext = context;
    }
}
