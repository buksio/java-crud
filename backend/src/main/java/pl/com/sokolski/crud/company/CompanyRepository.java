package pl.com.sokolski.crud.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CompanyRepository extends JpaRepository<Company, Integer> {
}
