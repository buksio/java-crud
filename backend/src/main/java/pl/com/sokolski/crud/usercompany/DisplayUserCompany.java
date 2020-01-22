package pl.com.sokolski.crud.usercompany;

import lombok.Value;

@Value
public class DisplayUserCompany {
  int id;
  int userId;
  int companyId;

  static DisplayUserCompany of(final UserCompany userCompany) {
    return new DisplayUserCompany(
        userCompany.getId(), userCompany.getUserId(), userCompany.getCompanyId());
  }
}
