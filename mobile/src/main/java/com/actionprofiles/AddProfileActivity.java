package com.actionprofiles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionprofiles.model.Profile;
import com.actionprofiles.model.ProfileFactory;
import com.actionprofiles.service.ProfileService;
import com.google.inject.Inject;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class AddProfileActivity extends RoboActionBarActivity {

  @Inject
  ProfileService profileService;

  @Inject
  ProfileFactory profileFactory;

  @InjectView(R.id.save_profile_btn)
  Button saveBtn;

  private Profile profile;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_profile);

    profile = profileFactory.createNewProfile();

    saveBtn.setOnClickListener(saveBtnOnClickListener());
  }

  private View.OnClickListener saveBtnOnClickListener() {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        profileService.add(profile);
      }
    };
  }

}
