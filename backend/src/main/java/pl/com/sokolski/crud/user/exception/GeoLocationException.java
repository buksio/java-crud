package pl.com.sokolski.crud.user.exception;

public class GeoLocationException extends RuntimeException {
  public GeoLocationException(String message) {
    super(message);
  }
}
