package pl.com.sokolski.crud.company;

import lombok.Value;
import pl.com.sokolski.crud.user.DisplayUser;

import java.util.List;

@Value
class DetailedCompany {
  DisplayCompany displayCompany;
  List<DisplayUser> displayUsers;
}
