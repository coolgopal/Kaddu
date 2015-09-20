package com.zero.debloper.kaddu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by debloper on 20/9/15.
 */
public class ProfileRecyclerViewActivity extends Activity{
    private List<Profile> profileList;
    private RecyclerView rv;
    private SwitchCompat switchCompatButton;
    private final String TAG = "ProfileRVActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        profileList = new ArrayList<>();
        profileList.add(new Profile("Sleeping", DynamicProfileManager.getInstance(this).isSleepingProfileActivated(), R.drawable.ic_sleeping2));
        profileList.add(new Profile("Meeting", DynamicProfileManager.getInstance(this).isMeetingProfileActivated(), R.drawable.ic_meeting2));
        profileList.add(new Profile("Home", DynamicProfileManager.getInstance(this).isHomeProfileActivated(), R.drawable.ic_home2));
    }

    private void initializeAdapter(){
        ProfileRecyclerViewAdapter adapter = new ProfileRecyclerViewAdapter(profileList, getApplicationContext());
        rv.setAdapter(adapter);
    }

}
