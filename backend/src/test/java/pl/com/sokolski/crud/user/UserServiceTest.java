package pl.com.sokolski.crud.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.com.sokolski.crud.company.CompanyService;
import pl.com.sokolski.crud.usercompany.UserCompanyService;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

  @Mock private UserRepository userRepository = mock(UserRepository.class);

  @Mock private UserCompanyService userCompanyService = mock(UserCompanyService.class);

  @Mock private CompanyService companyService = mock(CompanyService.class);

  private UserService subject;

  @BeforeEach
  void beforeEach() {
    this.subject = new UserService(userRepository, userCompanyService, companyService);
  }

  @Test
  void shouldReturnListOfUsers() {
    //given
    final List<Integer> userIds = Stream.of(1, 2, 3).collect(toList());
    final List<User> users = Stream.of(mock(User.class), mock(User.class)).collect(toList());

    when(userRepository.findAllById(userIds)).thenReturn(users);

    //when
    final List<DisplayUser> result = this.subject.findAllById(userIds);

    // then
    assertNotNull(result);
    assertEquals(result.size(), users.size());
  }
}
