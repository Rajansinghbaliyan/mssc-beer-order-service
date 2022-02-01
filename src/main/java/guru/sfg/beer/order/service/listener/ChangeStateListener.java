package guru.sfg.beer.order.service.listener;

import guru.sfg.beer.order.service.config.jms.JmsConfig;
import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.domain.OrderStatus;
import guru.sfg.beer.order.service.repository.BeerOrderRepository;
import guru.sfg.common.events.ChangeStateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChangeStateListener {
    private final BeerOrderRepository repository;

    @JmsListener(destination = JmsConfig.CHANGE_STATE_QUEUE)
    public void listener(ChangeStateEvent event){
        UUID beerOrderId = event.getBeerOrderId();

        log.info("Changing the stat of beer order id: " + beerOrderId);
        OrderStatus status = event.getBeerOrderState();

        BeerOrder beerOrder = repository.findById(beerOrderId).get();

        log.info(String.format("From: %s -> To: %s",beerOrder.getStatus(),status));
        beerOrder.setStatus(status);

        repository.save(beerOrder);
    }
}
