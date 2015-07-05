package com.actionprofiles.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * A database entity that represents a profile.
 *
 * @author Ben Sechrist
 */
@Table(name = "Profile")
public class ProfileEntity extends Model {

  @Column(notNull = true)
  private String name;

  @Column(notNull = true)
  private String triggers;

  @Column(notNull = true)
  private String actions;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTriggers() {
    return triggers;
  }

  public void setTriggers(String triggers) {
    this.triggers = triggers;
  }

  public String getActions() {
    return actions;
  }

  public void setActions(String actions) {
    this.actions = actions;
  }

  @Override
  public int hashCode() {
    return this.getId().hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProfileEntity)) return false;
    ProfileEntity that = (ProfileEntity) o;
    return this.getId().equals(that.getId());
  }
}
