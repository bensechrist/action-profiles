package com.actionprofiles.repository;

import com.actionprofiles.domain.ProfileEntity;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * @author Ben Sechrist
 */
public class ProfileRepository {

  From from = new Select().from(ProfileEntity.class);

  public List<ProfileEntity> fetchAll() {
    return from.execute();
  }

  public Long save(ProfileEntity entity) {
    return entity.save();
  }
}
