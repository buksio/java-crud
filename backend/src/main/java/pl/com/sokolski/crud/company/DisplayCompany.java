package pl.com.sokolski.crud.company;

import lombok.Value;

@Value
class DisplayCompany {
  int id;
  double latitude;
  double longitude;
  String location;

  static DisplayCompany of(final Company company) {
    return new DisplayCompany(
            company.getId(), company.getLatitude(), company.getLatitude(), company.getLocation());
  }
}
