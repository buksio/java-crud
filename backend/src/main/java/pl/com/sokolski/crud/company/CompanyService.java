package pl.com.sokolski.crud.company;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  public List<DisplayCompany> findAllById(final List<Integer> ids) {
    return companyRepository.findAllById(ids).stream().map(DisplayCompany::of).collect(toList());
  }

  List<DisplayCompany> findAll() {
    return companyRepository.findAll().stream().map(DisplayCompany::of).collect(toList());
  }

  void delete(final int id) {
    companyRepository.deleteById(id);
  }
}
