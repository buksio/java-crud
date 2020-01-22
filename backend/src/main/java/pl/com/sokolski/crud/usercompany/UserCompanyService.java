package pl.com.sokolski.crud.usercompany;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.com.sokolski.crud.company.CompanyService;
import pl.com.sokolski.crud.company.DisplayCompany;
import pl.com.sokolski.crud.user.DisplayUser;
import pl.com.sokolski.crud.user.UserService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserCompanyService {

  private final UserCompanyRepository userCompanyRepository;
  private final UserService userService;
  private final CompanyService companyService;

  public UserCompanyService(
      UserCompanyRepository userCompanyRepository,
      @Lazy UserService userService,
      @Lazy CompanyService companyService) {
    this.userCompanyRepository = userCompanyRepository;
    this.userService = userService;
    this.companyService = companyService;
  }

  public List<DisplayCompany> findAllByUserId(final int userId) {
    final List<Integer> companyIds =
        userCompanyRepository.findByUserId(userId).stream()
            .map(UserCompany::getCompanyId)
            .collect(toList());

    return companyService.findAllById(companyIds);
  }

  public List<DisplayUser> findAllByCompanyId(final int companyId) {
    final List<Integer> userIds =
        userCompanyRepository.findByUserId(companyId).stream()
            .map(UserCompany::getUserId)
            .collect(toList());

    return userService.findAllById(userIds);
  }

  DisplayUserCompany save(final NewUserCompany newUserCompany) {
    final UserCompany userCompany = userCompanyRepository.save(UserCompany.create(newUserCompany));

    return DisplayUserCompany.of(userCompany);
  }
}
