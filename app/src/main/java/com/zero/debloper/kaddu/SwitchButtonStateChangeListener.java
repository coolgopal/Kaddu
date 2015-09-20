package com.zero.debloper.kaddu;

import android.util.Log;
import android.widget.CompoundButton;

/**
 * Created by debloper on 20/9/15.
 */
public class SwitchButtonStateChangeListener implements CompoundButton.OnCheckedChangeListener {
    private final String TAG = "OnCheckedChangeListener";

    private int profile;
    SwitchButtonStateChangeListener(int profile) {
        this.profile = profile;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.v(TAG, "SwitchButtonStateChangeListener onCheckedChanged" + " profile[" + profile + "]=" + compoundButton.isChecked());
    }
}
