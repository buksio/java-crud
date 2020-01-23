package pl.com.sokolski.crud.company;

import lombok.Value;

@Value
class LocalizedCompany {
  String name;
  double latitude;
  double longitude;
  String location;
}
