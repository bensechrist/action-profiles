package com.sechristfamily.actionprofiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;


public class ProfilesActivity extends RoboActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.add_profile_fab)
    FloatingActionButton fab;

    @InjectResource(R.string.app_name)
    String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        toolbar.setTitle(appName);
        toolbar.setTitleTextColor(Color.WHITE);
    }

}
