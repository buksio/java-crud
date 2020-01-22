package pl.com.sokolski.crud.company;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
class CompanyService {

  private final CompanyRepository companyRepository;

  List<DisplayCompany> findAll() {
    return companyRepository.findAll().stream().map(DisplayCompany::of).collect(toList());
  }

  void delete(int id) {
    companyRepository.deleteById(id);
  }
}
