package com.actionprofiles.service;

import com.actionprofiles.domain.ProfileEntity;
import com.actionprofiles.model.Profile;
import com.actionprofiles.model.ProfileFactory;
import com.actionprofiles.repository.ProfileRepository;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import roboguice.inject.ContextSingleton;

/**
 * A service for working with profiles.
 *
 * @author Ben Sechrist
 */
@ContextSingleton
public class ProfileService {

  @Inject
  ProfileFactory profileFactory;

  @Inject
  ProfileEntityFactory profileEntityFactory;

  @Inject
  ProfileRepository profileRepository;

  public List<Profile> getAll() {
    List<ProfileEntity> entities = profileRepository.fetchAll();
    List<Profile> models = new ArrayList<>();
    for (ProfileEntity entity : entities) {
      models.add(profileFactory.createModel(entity));
    }
    return models;
  }

  public long add(Profile profile) {
    ProfileEntity entity = profileEntityFactory.createEntity(profile);
    return profileRepository.save(entity);
  }
}
