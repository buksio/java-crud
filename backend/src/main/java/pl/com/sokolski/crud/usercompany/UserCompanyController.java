package pl.com.sokolski.crud.usercompany;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usercompany")
@AllArgsConstructor
class UserCompanyController {
  private final UserCompanyService userCompanyService;

  @PostMapping
  ResponseEntity<DisplayUserCompany> save(@RequestBody final NewUserCompany newUserCompany) {
    return ResponseEntity.ok(userCompanyService.save(newUserCompany));
  }
}
