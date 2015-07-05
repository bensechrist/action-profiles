package com.actionprofiles;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.actionprofiles.adapter.ProfileAdapterFactory;
import com.actionprofiles.service.ProfileService;
import com.google.inject.Inject;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;


public class ProfilesActivity extends RoboActionBarActivity {

  @Inject
  ProfileService profileService;

  @Inject
  ProfileAdapterFactory profileAdapterFactory;

  @InjectView(R.id.profile_list)
  RecyclerView recyclerView;

  RecyclerView.LayoutManager layoutManager;

  @InjectView(R.id.toolbar)
  Toolbar toolbar;

  @InjectView(R.id.add_profile_fab)
  FloatingActionButton fab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//        ActiveAndroid.initialize(this);
    setContentView(R.layout.activity_profiles);
    toolbar.setTitleTextColor(Color.WHITE);
    setSupportActionBar(toolbar);

    recyclerView.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    RecyclerView.Adapter adapter = profileAdapterFactory.newAdapter(profileService.getAll());
    recyclerView.setAdapter(adapter);

    fab.setOnClickListener(onFabClickListener());
  }

  private View.OnClickListener onFabClickListener() {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(ProfilesActivity.this,
            AddProfileActivity.class);
        startActivity(intent);
      }
    };
  }

}
