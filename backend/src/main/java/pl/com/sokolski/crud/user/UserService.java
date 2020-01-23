package pl.com.sokolski.crud.user;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.com.sokolski.crud.company.CompanyService;
import pl.com.sokolski.crud.user.exception.UserNotFoundException;
import pl.com.sokolski.crud.usercompany.DisplayUserCompany;
import pl.com.sokolski.crud.usercompany.UserCompanyService;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserCompanyService userCompanyService;
  private final CompanyService companyService;

  public UserService(
      UserRepository userRepository,
      UserCompanyService userCompanyService,
      @Lazy CompanyService companyService) {
    this.userRepository = userRepository;
    this.userCompanyService = userCompanyService;
    this.companyService = companyService;
  }

  public List<DisplayUser> findAllById(final List<Integer> ids) {
    return userRepository.findAllById(ids).stream().map(DisplayUser::of).collect(toList());
  }

  DetailedUser find(final int id) {
    final User user =
        userRepository
            .findById(id)
            .orElseThrow(
                () -> new UserNotFoundException(format("Could not find user with id: %d", id)));

    final List<Integer> companyIds =
        userCompanyService.findAllByUserId(user.getId()).stream()
            .map(DisplayUserCompany::getCompanyId)
            .collect(toList());

    return new DetailedUser(DisplayUser.of(user), companyService.findAllById(companyIds));
  }

  List<DisplayUser> findAll() {
    return userRepository.findAll().stream().map(DisplayUser::of).collect(toList());
  }

  DisplayUser save(final NewUser newUser) {
    final User user = userRepository.save(User.create(newUser));
    return DisplayUser.of(user);
  }
}
