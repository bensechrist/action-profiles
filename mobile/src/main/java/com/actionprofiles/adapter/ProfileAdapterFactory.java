package com.actionprofiles.adapter;

import android.support.v7.widget.RecyclerView;

import com.actionprofiles.model.Profile;

import java.util.List;

import roboguice.inject.ContextSingleton;

/**
 * @author Ben Sechrist
 */
@ContextSingleton
public class ProfileAdapterFactory {
  public RecyclerView.Adapter newAdapter(List<Profile> profiles) {
    return new ProfileAdapter(profiles);
  }
}
