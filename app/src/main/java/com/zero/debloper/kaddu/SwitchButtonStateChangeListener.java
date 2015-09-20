package com.zero.debloper.kaddu;

import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;

/**
 * Created by debloper on 20/9/15.
 */
public class SwitchButtonStateChangeListener implements CompoundButton.OnCheckedChangeListener {
    private final String TAG = "OnCheckedChangeListener";

    private int profile;
    private Context context;
    SwitchButtonStateChangeListener(int profile, Context context) {
        this.profile = profile;
        this.context = context;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.v(TAG, "SwitchButtonStateChangeListener onCheckedChanged" + " profile[" + profile + "]=" + compoundButton.isChecked());
        DynamicProfileManager.getInstance(context).setCurrentProfile(profile);
    }
}
