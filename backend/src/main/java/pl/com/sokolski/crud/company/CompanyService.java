package pl.com.sokolski.crud.company;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.sokolski.crud.company.exception.CompanyNotFoundException;
import pl.com.sokolski.crud.usercompany.UserCompanyService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class CompanyService {

  private final CompanyRepository companyRepository;
  private final UserCompanyService userCompanyService;

  public List<DisplayCompany> findAllById(final List<Integer> ids) {
    return companyRepository.findAllById(ids).stream().map(DisplayCompany::of).collect(toList());
  }

  DetailedCompany find(final int id) {
    final Company company =
        companyRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new CompanyNotFoundException(
                        String.format("Could not find company with id: %d", id)));

    return new DetailedCompany(
        DisplayCompany.of(company), userCompanyService.findAllByCompanyId(id));
  }

  List<DisplayCompany> findAll() {
    return companyRepository.findAll().stream().map(DisplayCompany::of).collect(toList());
  }

  void delete(final int id) {
    companyRepository.deleteById(id);
  }
}
