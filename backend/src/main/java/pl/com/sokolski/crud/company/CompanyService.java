package pl.com.sokolski.crud.company;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.com.sokolski.crud.company.exception.CompanyNotFoundException;
import pl.com.sokolski.crud.user.UserService;
import pl.com.sokolski.crud.usercompany.DisplayUserCompany;
import pl.com.sokolski.crud.usercompany.UserCompanyService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;
  private final UserCompanyService userCompanyService;
  private final UserService userService;
  private final GeoLocationService geoLocationService;

  public CompanyService(
      CompanyRepository companyRepository,
      UserCompanyService userCompanyService,
      @Lazy UserService userService,
      GeoLocationService geoLocationService) {
    this.companyRepository = companyRepository;
    this.userCompanyService = userCompanyService;
    this.userService = userService;
    this.geoLocationService = geoLocationService;
  }

  public List<DisplayCompany> findAllById(final List<Integer> ids) {
    return companyRepository.findAllById(ids).stream().map(DisplayCompany::of).collect(toList());
  }

  public DisplayCompany save(final NewCompany newCompany) {
    final String location =
        geoLocationService.getLocation(newCompany.getLatitude(), newCompany.getLatitude());

    final LocalizedCompany localizedCompany =
        new LocalizedCompany(
            newCompany.getName(), newCompany.getLatitude(), newCompany.getLongitude(), location);

    final Company company = companyRepository.save(Company.create(localizedCompany));

    return DisplayCompany.of(company);
  }

  DetailedCompany find(final int id) {
    final Company company =
        companyRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new CompanyNotFoundException(
                        String.format("Could not find company with id: %d", id)));

    final List<Integer> userIds =
        userCompanyService.findAllByCompanyId(company.getId()).stream()
            .map(DisplayUserCompany::getUserId)
            .collect(toList());

    return new DetailedCompany(DisplayCompany.of(company), userService.findAllById(userIds));
  }

  List<DisplayCompany> findAll() {
    return companyRepository.findAll().stream().map(DisplayCompany::of).collect(toList());
  }

  void delete(final int id) {
    companyRepository.deleteById(id);
  }
}
