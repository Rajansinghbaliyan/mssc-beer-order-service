package guru.sfg.beer.order.service.repository;

import guru.sfg.beer.order.service.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, UUID> {

}
