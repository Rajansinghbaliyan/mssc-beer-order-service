package guru.sfg.beer.order.service.web.controllers;

import guru.sfg.beer.order.service.services.BeerOrderService;
import guru.sfg.beer.order.service.web.models.BeerOrderDto;
import guru.sfg.beer.order.service.web.models.BeerOrderPagedList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/{customerId}/beer-order")
@RequiredArgsConstructor
@Slf4j
public class BeerOrderController {

    private final BeerOrderService beerOrderService;

    @GetMapping("/")
    public ResponseEntity<BeerOrderPagedList> findAllOrderByCustomerId(@PathVariable UUID customerId) {
        log.debug("Get Beer Order For Customer: " + customerId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(beerOrderService.listOrders(customerId, PageRequest.of(0, 25)));

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BeerOrderDto> findById(@PathVariable UUID customerId,@PathVariable UUID uuid){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(beerOrderService.getOrderById(customerId,uuid));
    }

    @PostMapping("/")
    public ResponseEntity<BeerOrderDto> placeOrder(@PathVariable UUID customerId, @RequestBody BeerOrderDto beerOrderDto) {
        log.debug("Post Beer Order For Customer: " + customerId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(beerOrderService.placeOrder(customerId, beerOrderDto));
    }
}
