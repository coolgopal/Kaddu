package com.zero.debloper.kaddu;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by debloper on 20/9/15.
 */
public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.ProfileViewHolder>  {
    public static class ProfileViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView profileIcon;
        TextView profileName;
        SwitchCompat switchCompatButton;

        ProfileViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            profileIcon = (ImageView) itemView.findViewById(R.id.profile_icon);
            profileName = (TextView) itemView.findViewById(R.id.profile_name);
            switchCompatButton = (SwitchCompat) itemView.findViewById(R.id.switch_compat);
        }
    }

    List<Profile> profiles;
    Context context;

    ProfileRecyclerViewAdapter(List<Profile> profiles, Context context){
        this.profiles = profiles;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_card_view, viewGroup, false);
        ProfileViewHolder pvh = new ProfileViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder personViewHolder, int i) {
        personViewHolder.profileIcon.setImageResource(profiles.get(i).iconId);
        personViewHolder.profileName.setText(profiles.get(i).name);
        personViewHolder.switchCompatButton.setOnCheckedChangeListener(new SwitchButtonStateChangeListener(i));
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }
}
