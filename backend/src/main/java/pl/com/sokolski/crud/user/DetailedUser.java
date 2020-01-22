package pl.com.sokolski.crud.user;

import lombok.Value;
import pl.com.sokolski.crud.company.DisplayCompany;

import java.util.List;

@Value
class DetailedUser {
  DisplayUser displayUser;
  List<DisplayCompany> displayCompanies;
}
