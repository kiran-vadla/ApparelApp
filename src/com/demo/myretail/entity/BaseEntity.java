package com.demo.myretail.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Version;

/**
 * @author vkiran
 *
 */

public abstract class BaseEntity {

  @Id
  @Property("id")
  protected ObjectId id;

  @Version
  @Property("version")
  private Long version;

  public BaseEntity() {
    super();
  }

  public ObjectId getId() {

    return this.id;
  }

  public void setId(ObjectId id) {

    this.id = id;
  }

  public Long getVersion() {

    return this.version;
  }

  public void setVersion(Long version) {

    this.version = version;
  }

}
