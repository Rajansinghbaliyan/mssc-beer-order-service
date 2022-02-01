package guru.sfg.beer.order.service.services.beer.service;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import guru.sfg.beer.order.service.web.controllers.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@Profile("!local-discovery")
public class BeerServiceRestTemplate implements BeerService {

    private final RestTemplate restTemplate;
    private final String HOST;
    public static final String BASE = "/api/v1/beer/";

    public BeerServiceRestTemplate(RestTemplateBuilder builder,
                                   @Value("${beer_service}") String HOST) {
        this.restTemplate = builder.build();
        this.HOST = HOST;
    }

    private String getUrl(UUID beerId) {
        return HOST + "/api/v1/beer/" + beerId.toString();
    }

    @Override
    public BeerDto getBeerData(UUID beerId) throws NotFoundException, HttpClientErrorException {
//        URI getBeer = new URIBuilder()
//                .setScheme("http")
//                .setHost(HOST)
//                .setPath("/api/v1/beer"+beerId)
//                .setParameter("showInventory","true")
//                .build();


        ResponseEntity<BeerDto> response = restTemplate
                .exchange(getUrl(beerId),
                        HttpMethod.GET,
                        null,
                        BeerDto.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new NotFoundException();
        }
    }
}
