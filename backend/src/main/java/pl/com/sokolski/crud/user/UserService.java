package pl.com.sokolski.crud.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public List<DisplayUser> findAllById(final List<Integer> ids) {
    return userRepository.findAllById(ids).stream().map(DisplayUser::of).collect(toList());
  }

  List<DisplayUser> findAll() {
    return userRepository.findAll().stream().map(DisplayUser::of).collect(toList());
  }

  DisplayUser save(final NewUser newUser) {
    final User user = userRepository.save(User.create(newUser));
    return DisplayUser.of(user);
  }
}
