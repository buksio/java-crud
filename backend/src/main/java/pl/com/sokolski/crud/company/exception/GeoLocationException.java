package pl.com.sokolski.crud.company.exception;

public class GeoLocationException extends RuntimeException {
  public GeoLocationException(String message) {
    super(message);
  }
}
