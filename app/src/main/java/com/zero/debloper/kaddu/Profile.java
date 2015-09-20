package com.zero.debloper.kaddu;

/**
 * Created by debloper on 19/9/15.
 */
public class Profile {
    String name;
    boolean isEnabled;
    int iconId;

    Profile(String name, boolean isEnabled, int iconId){
        this.name = name;
        this.isEnabled = isEnabled;
        this.iconId = iconId;
    }
}
