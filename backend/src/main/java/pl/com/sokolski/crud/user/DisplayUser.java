package pl.com.sokolski.crud.user;

import lombok.Value;

@Value
public class DisplayUser {
  int id;
  String name;
  String surname;

  static DisplayUser of(final User user) {
    return new DisplayUser(user.getId(), user.getName(), user.getSurname());
  }
}
