package guru.sfg.beer.order.service.web.controllers;

import guru.sfg.beer.order.service.services.BeerOrderService;
import guru.sfg.beer.order.service.web.models.BeerOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/{customerId}/beer-order")
@RequiredArgsConstructor
public class BeerOrderController {

    private final BeerOrderService beerOrderService;

    @PostMapping("/")
    public ResponseEntity<BeerOrderDto> placeOrder(@PathVariable String customerId, @RequestBody BeerOrderDto beerOrderDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(beerOrderService.placeOrder(UUID.fromString(customerId), beerOrderDto));
    }
}
