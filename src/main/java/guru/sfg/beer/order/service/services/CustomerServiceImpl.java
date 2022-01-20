package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.repository.CustomerRepository;
import guru.sfg.beer.order.service.web.mappers.CustomerMapper;
import guru.sfg.beer.order.service.web.models.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerDto> findAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(mapper::customerToDto)
                .collect(Collectors.toList());
    }
}
