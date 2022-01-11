package guru.sfg.beer.order.service.web.controllers;

import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.services.CustomerService;
import guru.sfg.beer.order.service.web.models.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getOrderById() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.findAll());
    }
}
