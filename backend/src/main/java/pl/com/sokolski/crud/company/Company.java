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

  @Column(name = "latitude")
  private double latitude;

  @Column(name = "longitude")
  private double longitude;

  @Column(name = "location")
  private String location;
}
