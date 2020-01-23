package pl.com.sokolski.crud.company;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  ResponseEntity<DisplayCompany> save(@RequestBody final NewCompany newCompany) {
    return ResponseEntity.ok(companyService.save(newCompany));
  }

  @GetMapping("/{id}")
  ResponseEntity<DetailedCompany> find(@RequestParam final int id) {
    return ResponseEntity.ok(companyService.find(id));
  }

  @DeleteMapping("/{id}")
  ResponseEntity delete(@RequestParam final int id) {
    companyService.delete(id);
    return ResponseEntity.ok().body(id);
  }
}
