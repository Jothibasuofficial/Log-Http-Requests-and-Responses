package com.jothibasu.learning.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {
  @Id
  public ObjectId _id;
  
  public String name;
  public String age;
  public String sex;
  
  // Constructors
  public Users() {}
  
  public Users(ObjectId _id, String name, String age, String sex) {
    this._id = _id;
    this.name = name;
    this.age = age;
    this.sex = sex;
  }
  
  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public String getAge() { return age; }
  public void setAge(String age) { this.age = age; }
  
  public String getSex() { return sex; }
  public void setSex(String sex) { this.sex = sex; }
}