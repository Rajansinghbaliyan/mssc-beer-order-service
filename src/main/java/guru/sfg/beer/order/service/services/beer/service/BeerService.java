package guru.sfg.beer.order.service.services.beer.service;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerData(UUID beerId) throws Exception;
}
