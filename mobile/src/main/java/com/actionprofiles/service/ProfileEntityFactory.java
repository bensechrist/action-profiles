package com.actionprofiles.service;

import com.actionprofiles.domain.ProfileEntity;
import com.actionprofiles.model.Profile;

/**
 * A factory for creating {@link ProfileEntity} objects.
 *
 * @author Ben Sechrist
 */
public class ProfileEntityFactory {

  /**
   * Creates a {@link ProfileEntity} from the given model
   *
   * @param profile Model to represent a profile
   * @return New profile entity
   */
  public ProfileEntity createEntity(Profile profile) {
    ProfileEntity entity = new ProfileEntity();
    entity.setName(profile.name);
    return entity;
  }

}
