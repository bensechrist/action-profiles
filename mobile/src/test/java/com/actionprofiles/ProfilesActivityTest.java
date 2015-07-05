package com.actionprofiles;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

import com.actionprofiles.adapter.ProfileAdapter;
import com.actionprofiles.adapter.ProfileAdapterFactory;
import com.actionprofiles.model.Profile;
import com.actionprofiles.service.ProfileService;
import com.google.inject.AbstractModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import java.util.Collections;
import java.util.List;

import roboguice.RoboGuice;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

/**
 * @author Ben Sechrist
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class ProfilesActivityTest {

  ProfileService profileService = mock(ProfileService.class);

  ProfileAdapterFactory profileAdapterFactory = mock(ProfileAdapterFactory.class);

  ProfileAdapter profileAdapter = mock(ProfileAdapter.class);

  RecyclerView recyclerView = mock(RecyclerView.class);

  Profile profile = mock(Profile.class);

  FloatingActionButton fab;

  ProfilesActivity activity;

  @Before
  public void setup() {
    List<Profile> profileList = Collections.singletonList(profile);
    when(profileService.getAll()).thenReturn(profileList);
    when(profileAdapterFactory.newAdapter(profileList)).thenReturn(profileAdapter);
    doNothing().when(recyclerView).setAdapter(profileAdapter);

    RoboGuice.overrideApplicationInjector(RuntimeEnvironment.application, new TestModule());
    activity = Robolectric.setupActivity(ProfilesActivity.class);
    fab = (FloatingActionButton) activity.findViewById(R.id.add_profile_fab);
  }

  @Test
  public void clickingFab_shouldLaunchAddProfileActivityIntent() throws Exception {
    fab.performClick();

    ShadowActivity shadowActivity = shadowOf(activity);
    Intent startedIntent = shadowActivity.getNextStartedActivity();
    ShadowIntent shadowIntent = shadowOf(startedIntent);
    assertThat(shadowIntent.getComponent().getClassName(),
        equalTo(AddProfileActivity.class.getName()));
  }

  public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
      bind(ProfileService.class).toInstance(profileService);
      bind(ProfileAdapterFactory.class).toInstance(profileAdapterFactory);
      bind(RecyclerView.class).toInstance(recyclerView);
    }
  }
}
