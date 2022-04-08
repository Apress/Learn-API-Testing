package com.contact.mgmt.model;

/**
 * Contact Model class has id, firstName, lastNAme and email of a contact.
 *
 * <p>Contact Model will be used by Jackson parser for paring the http response.
 *
 * @author Jagdeep Jain
 */
public class Contact {

  private int id;
  private String firstName;
  private String lastName;
  private String email;

  public int getId() {
    return id;
  }

  public Contact setId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Contact setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Contact setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Contact setEmail(String email) {
    this.email = email;
    return this;
  }
}
