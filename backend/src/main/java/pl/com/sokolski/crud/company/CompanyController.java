package pl.com.sokolski.crud.company;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
class CompanyController {

  private final CompanyService companyService;

  @GetMapping
  ResponseEntity<List<DisplayCompany>> findAll() {
    return ResponseEntity.ok(companyService.findAll());
  }

  @PostMapping
  ResponseEntity<DisplayCompany> save(final NewCompany newCompany) {
    return ResponseEntity.ok(companyService.save(newCompany));
  }

  @GetMapping("/{id}")
  ResponseEntity<DetailedCompany> find(@PathVariable final int id) {
    return ResponseEntity.ok(companyService.find(id));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Integer> delete(@PathVariable final int id) {
    companyService.delete(id);
    return ResponseEntity.ok().body(id);
  }
}
