package pl.com.sokolski.crud.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
class UserController {

  private final UserService userService;

  @GetMapping
  ResponseEntity<List<DisplayUser>> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @PostMapping
  ResponseEntity<DisplayUser> save(final NewUser newUser) {
    return ResponseEntity.ok(userService.save(newUser));
  }

  @GetMapping("/{id}")
  ResponseEntity<DetailedUser> find(@PathVariable final int id) {
    return ResponseEntity.ok(userService.find(id));
  }
}
