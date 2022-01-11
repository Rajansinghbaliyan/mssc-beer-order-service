package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.web.models.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();
}
