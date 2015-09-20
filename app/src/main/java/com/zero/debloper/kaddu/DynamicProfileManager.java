package com.zero.debloper.kaddu;

import android.content.Context;

/**
 * Created by debloper on 20/9/15.
 */
public class DynamicProfileManager {

    // Available profiles
    public static int PROFILE_SLEEPING = 0;
    public static int PROFILE_MEETING = 1;
    public static int PROFILE_HOME = 2;

    private static DynamicProfileManager mDynamicProfileManager = null;
    Context mContext;
    int currentProfile;

    private DynamicProfileManager(Context context) {
        mContext = context;
    }

    public static DynamicProfileManager getInstance(Context context) {
        if (mDynamicProfileManager == null) {
            mDynamicProfileManager = new DynamicProfileManager(context);
        }

        return mDynamicProfileManager;
    }

    public void setCurrentProfile(int profile) {
        currentProfile = profile;
    }

    public int getCurrentProfile() {
        return currentProfile;
    }
}
