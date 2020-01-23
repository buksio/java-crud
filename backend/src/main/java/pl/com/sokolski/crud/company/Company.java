package pl.com.sokolski.crud.company;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "latitude")
  private double latitude;

  @Column(name = "longitude")
  private double longitude;

  @Column(name = "location")
  private String location;

  static Company create(final LocalizedCompany localizedCompany) {
    final Company company = new Company();

    company.setName(localizedCompany.getName());
    company.setLatitude(localizedCompany.getLatitude());
    company.setLongitude(localizedCompany.getLongitude());
    company.setLocation(localizedCompany.getLocation());

    return company;
  }
}
