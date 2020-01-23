package pl.com.sokolski.crud.usercompany;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserCompanyRepository extends JpaRepository<UserCompany, Integer> {
  List<UserCompany> findAllByUserId(int userId);

  List<UserCompany> findAllByCompanyId(int companyId);
}
