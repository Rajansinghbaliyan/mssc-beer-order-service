package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.client.BeerServiceClient;
import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.domain.OrderStatus;
import guru.sfg.beer.order.service.repository.BeerOrderLineRepository;
import guru.sfg.beer.order.service.repository.BeerOrderRepository;
import guru.sfg.beer.order.service.repository.CustomerRepository;
import guru.sfg.beer.order.service.web.controllers.NotFoundException;
import guru.sfg.beer.order.service.web.mappers.BeerOrderLineMapper;
import guru.sfg.beer.order.service.web.mappers.BeerOrderMapper;
import guru.sfg.beer.order.service.web.models.BeerDto;
import guru.sfg.beer.order.service.web.models.BeerOrderDto;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;
import guru.sfg.beer.order.service.web.models.BeerOrderPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerOrderServiceImpl implements BeerOrderService {
    private final BeerOrderRepository beerOrderRepository;
    private final CustomerRepository customerRepository;
    private final BeerOrderLineRepository beerOrderLineRepository;

    private final BeerOrderMapper beerOrderMapper;
    private final BeerOrderLineMapper beerOrderLineMapper;
    private final BeerServiceClient client;

    @Override
    public BeerOrderPagedList listOrders(UUID customerId, Pageable pageable) {
        return null;
    }

    @Override
    public BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(NotFoundException::new);

        List<BeerDto> beerDtoList = beerOrderDto.getBeerOrderLines()
                .stream()
                .map(BeerOrderLineDto::getBeerId)
                .map(client::getBeerById)
                .collect(Collectors.toList());

        BeerOrder beerOrder = beerOrderMapper.dtoToBeerOrder(beerOrderDto);
        beerOrder.setCustomer(customer);
        beerOrder.setStatus(OrderStatus.NEW);
        beerOrder.getBeerOrderLines().forEach(line-> line.setBeerOrder(beerOrder));

        return beerOrderMapper.beerOrderToDto(beerOrderRepository.save(beerOrder));
    }

    @Override
    public BeerOrderDto getOrderById(UUID customerId, UUID orderId) {
        return null;
    }

    @Override
    public void pickupOrder(UUID customerId, UUID orderId) {

    }
}
