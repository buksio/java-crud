package pl.com.sokolski.crud.user;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.sokolski.crud.user.exception.GeoLocationException;

import java.util.HashMap;

import static java.lang.String.format;

@Service
public class GeoLocationService {
  private final String url;
  private final String key;
  private final RestTemplate template = new RestTemplate();

  public GeoLocationService(
      @Value("${google.geolocation.url}") String url,
      @Value("${google.geolocation.api_key}") String key) {
    this.url = url;
    this.key = key;
  }

  public String getLocation(final double latitude, final double longitude) {
    final HashMap<String, String> parameters = new HashMap<>();
    parameters.put("latlng", latitude + "," + longitude);
    parameters.put("key", key);

    final ResponseEntity<String> exchange =
        template.exchange(
            url + "?latlng={latlng}&key={key}", HttpMethod.GET, null, String.class, parameters);
    final String body = exchange.getBody();
    final JSONObject jsonObject = new JSONObject(body);

    final String status = jsonObject.getString("status");
    if (!"OK".equals(status)) {
      throw new GeoLocationException(
          format("Error while retrieving address of location: %f, %f", latitude, longitude));
    }

    return jsonObject.getJSONArray("results").getJSONObject(0).getString("formatted_address");
  }
}
