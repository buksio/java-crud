package pl.com.sokolski.crud.usercompany;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.sokolski.crud.company.CompanyService;
import pl.com.sokolski.crud.company.DisplayCompany;
import pl.com.sokolski.crud.user.DisplayUser;
import pl.com.sokolski.crud.user.UserService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class UserCompanyService {

  private final UserCompanyRepository userCompanyRepository;
  private final CompanyService companyService;
  private final UserService userService;

  public List<DisplayCompany> findAllByUserId(final int userId) {
    final List<UserCompany> usersCompanies = userCompanyRepository.findByUserId(userId);
    final List<Integer> companyIds =
            usersCompanies.stream().map(UserCompany::getCompanyId).collect(toList());

    return companyService.findAllById(companyIds);
  }

  public List<DisplayUser> findAllByCompanyId(final int companyId) {
    final List<UserCompany> usersCompanies = userCompanyRepository.findByCompanyId(companyId);
    final List<Integer> userIds =
            usersCompanies.stream().map(UserCompany::getUserId).collect(toList());

    return userService.findAllById(userIds);
  }

  DisplayUserCompany save(final NewUserCompany newUserCompany) {
    final UserCompany userCompany = userCompanyRepository.save(UserCompany.create(newUserCompany));

    return DisplayUserCompany.of(userCompany);
  }
}
