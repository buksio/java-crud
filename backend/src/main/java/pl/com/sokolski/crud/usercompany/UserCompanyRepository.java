package pl.com.sokolski.crud.usercompany;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserCompanyRepository extends JpaRepository<UserCompany, Integer> {
  List<UserCompany> findByUserId(int userId);

  List<UserCompany> findByCompanyId(int companyId);
}
