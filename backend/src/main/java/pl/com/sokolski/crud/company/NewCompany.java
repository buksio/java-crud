package pl.com.sokolski.crud.company;

import lombok.Value;

@Value
class NewCompany {
  String name;
  double latitude;
  double longitude;
}
