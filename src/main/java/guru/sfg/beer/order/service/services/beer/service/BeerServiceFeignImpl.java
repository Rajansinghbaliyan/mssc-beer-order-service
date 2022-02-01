package guru.sfg.beer.order.service.services.beer.service;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import guru.sfg.beer.order.service.web.controllers.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
@Profile("local-discovery")
public class BeerServiceFeignImpl implements BeerService {

    private final BeerServiceFeign beerServiceFeign;

    @Override
    public BeerDto getBeerData(UUID beerId) {
        ResponseEntity<BeerDto> response = beerServiceFeign.getBeerData(beerId);

        if (response.getStatusCode() == HttpStatus.CREATED && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new NotFoundException();
        }
    }
}
