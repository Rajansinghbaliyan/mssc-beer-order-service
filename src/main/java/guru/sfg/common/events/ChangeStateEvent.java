package guru.sfg.common.events;

import guru.sfg.beer.order.service.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeStateEvent {
    private UUID beerOrderId;
    private OrderStatus beerOrderState;
}
