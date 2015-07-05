package com.actionprofiles.service;

import com.actionprofiles.domain.ProfileEntity;
import com.actionprofiles.model.Profile;
import com.actionprofiles.model.ProfileFactory;
import com.actionprofiles.repository.ProfileRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Ben Sechrist
 */
public class ProfileServiceTest {

  ProfileFactory profileFactory = mock(ProfileFactory.class);

  ProfileEntityFactory profileEntityFactory = mock(ProfileEntityFactory.class);

  ProfileRepository profileRepository = mock(ProfileRepository.class);

  ProfileEntity entity = mock(ProfileEntity.class);

  Profile model = mock(Profile.class);

  private ProfileService service = new ProfileService();

  @Before
  public void setUp() throws Exception {
    service.profileFactory = profileFactory;
    service.profileEntityFactory = profileEntityFactory;
    service.profileRepository = profileRepository;
  }

  @Test
  public void testGetAll() throws Exception {
    when(profileRepository.fetchAll()).thenReturn(Collections.singletonList(entity));
    when(profileFactory.createModel(entity)).thenReturn(model);

    List<Profile> result = service.getAll();
    assertThat(result.get(0), sameInstance(model));
  }

  @Test
  public void testAdd() throws Exception {
    final Long id = -1L;

    when(profileEntityFactory.createEntity(model)).thenReturn(entity);
    when(profileRepository.save(entity)).thenReturn(id);

    Long result = service.add(model);
    assertEquals(result, id);
  }
}