package guru.sfg.beer.order.service.services.beer.service;

import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "beer-service")
public interface BeerServiceFeign {

    @RequestMapping(method = RequestMethod.GET, value = BeerServiceRestTemplate.BASE)
    ResponseEntity<BeerDto> getBeerData(@PathVariable UUID beerId);
}
