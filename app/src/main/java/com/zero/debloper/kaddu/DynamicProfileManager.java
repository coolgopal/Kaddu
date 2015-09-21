package com.zero.debloper.kaddu;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by debloper on 20/9/15.
 */
public class DynamicProfileManager {
    private final String TAG = "DynamicProfileManager";

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

        if (profile == PROFILE_SLEEPING) {
            Toast.makeText(mContext, "Sleeping Mode Activated.", Toast.LENGTH_SHORT).show();
            activateSleepingProfile();
        } else if (profile == PROFILE_MEETING) {
            Toast.makeText(mContext, "Meeting Mode Activated.", Toast.LENGTH_SHORT).show();
            activateMeetingProfile();
        } else if (profile == PROFILE_HOME) {
            Toast.makeText(mContext, "Home Mode Activated.", Toast.LENGTH_SHORT).show();
            activateHomeProfile();
        }
    }

    public int getCurrentProfile() {
        return currentProfile;
    }

    public boolean isSleepingProfileActivated() {
        return (currentProfile == PROFILE_SLEEPING) ? true : false;
    }

    public boolean isMeetingProfileActivated() {
        return (currentProfile == PROFILE_MEETING) ? true : false;
    }

    public boolean isHomeProfileActivated() {
        return (currentProfile == PROFILE_HOME) ? true : false;
    }

    private final String COMMAND_ACTIVATE_PROFILE_SLEEPING = "sleeping";
    private final String COMMAND_ACTIVATE_PROFILE_MEETING = "meeting";
    private final String COMMAND_ACTIVATE_PROFILE_HOME = "home";

    public void parseVoiceCommand(String command) {
        Log.v(TAG, "parseVoiceCommand <" + command + ">");
        if (command.contains(COMMAND_ACTIVATE_PROFILE_SLEEPING)) {
            DynamicProfileManager.getInstance(mContext).setCurrentProfile(PROFILE_SLEEPING);
        } else if (command.contains(COMMAND_ACTIVATE_PROFILE_MEETING)) {
            DynamicProfileManager.getInstance(mContext).setCurrentProfile(PROFILE_MEETING);
        } else if (command.contains(COMMAND_ACTIVATE_PROFILE_HOME)) {
            DynamicProfileManager.getInstance(mContext).setCurrentProfile(PROFILE_HOME);
        } else {
            Toast.makeText(mContext, "Sorry, didn't get you!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void activateSleepingProfile() {
        final AudioManager mode = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mode.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    public void activateMeetingProfile() {
        final AudioManager mode = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mode.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    public void activateHomeProfile() {
        final AudioManager mode = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mode.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }
}
