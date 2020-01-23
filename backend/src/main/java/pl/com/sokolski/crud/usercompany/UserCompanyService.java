package pl.com.sokolski.crud.usercompany;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class UserCompanyService {

  private final UserCompanyRepository userCompanyRepository;

  public List<DisplayUserCompany> findAllByUserId(final int userId) {
    return userCompanyRepository.findAllByUserId(userId).stream()
        .map(DisplayUserCompany::of)
        .collect(toList());
  }

  public List<DisplayUserCompany> findAllByCompanyId(final int companyId) {
    return userCompanyRepository.findAllByCompanyId(companyId).stream()
        .map(DisplayUserCompany::of)
        .collect(toList());
  }

  DisplayUserCompany save(final NewUserCompany newUserCompany) {
    final UserCompany userCompany = userCompanyRepository.save(UserCompany.create(newUserCompany));

    return DisplayUserCompany.of(userCompany);
  }
}
