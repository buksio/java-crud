package pl.com.sokolski.crud.company;

import lombok.Value;

@Value
class NewCompany {
  double latitude;
  double longitude;
  String location;
}
