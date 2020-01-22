package pl.com.sokolski.crud.company.exception;

public class CompanyNotFoundException extends RuntimeException {
  public CompanyNotFoundException(String message) {
    super(message);
  }
}
