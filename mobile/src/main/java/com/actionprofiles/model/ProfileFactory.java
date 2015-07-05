package com.actionprofiles.model;

import com.actionprofiles.domain.ProfileEntity;

/**
 * A factory for producing {@link Profile} models.
 *
 * @author Ben Sechrist
 */
public class ProfileFactory {

  /**
   * Creates a new empty profile.
   *
   * @return A new profile
   */
  public Profile createNewProfile() {
    return null;
  }

  public Profile createModel(ProfileEntity entity) {
    Profile model = new Profile();
    model.id = entity.getId();
    model.name = entity.getName();
    return model;
  }
}
