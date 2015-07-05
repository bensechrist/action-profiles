package com.actionprofiles;

import android.widget.Button;

import com.actionprofiles.model.Profile;
import com.actionprofiles.model.ProfileFactory;
import com.actionprofiles.service.ProfileService;
import com.google.inject.AbstractModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import roboguice.RoboGuice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Ben Sechrist
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class AddProfileActivityTest {

  private ProfileService profileService = mock(ProfileService.class);

  private ProfileFactory profileFactory = mock(ProfileFactory.class);

  private Profile profile = mock(Profile.class);

  private Button saveBtn;

  private AddProfileActivity activity;

  @Before
  public void setup() {
    when(profileFactory.createNewProfile()).thenReturn(profile);

    RoboGuice.overrideApplicationInjector(RuntimeEnvironment.application, new TestModule());
    activity = Robolectric.setupActivity(AddProfileActivity.class);
    saveBtn = (Button) activity.findViewById(R.id.save_profile_btn);
  }

  @Test
  public void clickingSave_shouldCallAddOnProfileService() throws Exception {
    when(profileService.add(profile)).thenReturn(1L);

    saveBtn.performClick();
  }

  public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
      bind(ProfileService.class).toInstance(profileService);
      bind(ProfileFactory.class).toInstance(profileFactory);
    }
  }

}
