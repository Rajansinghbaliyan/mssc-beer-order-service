package guru.sfg.beer.order.service.client;

import guru.sfg.beer.order.service.web.controllers.NotFoundException;
import guru.sfg.beer.order.service.web.models.BeerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class BeerServiceClient {
    private RestTemplate restTemplate;
    private final String HOST;
    private final String BASE = "/api/v1/beer/";

    private BeerDto beerDto;

    private String getUrl(UUID uuid) {
        return HOST + BASE + uuid.toString();
    }

    public BeerServiceClient(RestTemplateBuilder builder, @Value("${beer_service}") String HOST) {
        this.restTemplate = builder.build();
        this.HOST = HOST;
    }

    public BeerDto getBeerById(UUID beerID) {
        try {
            ResponseEntity<BeerDto> response = restTemplate.getForEntity(getUrl(beerID), BeerDto.class);
            if (response.getStatusCode() == HttpStatus.OK)
                return response.getBody();
            else throw new NotFoundException();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
