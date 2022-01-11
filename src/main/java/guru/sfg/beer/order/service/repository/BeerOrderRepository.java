package guru.sfg.beer.order.service.repository;

import guru.sfg.beer.order.service.domain.BeerOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerOrderRepository extends PagingAndSortingRepository<BeerOrder, UUID> {
}
