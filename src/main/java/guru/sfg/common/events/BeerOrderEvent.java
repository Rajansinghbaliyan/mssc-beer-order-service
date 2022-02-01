package guru.sfg.common.events;

import guru.sfg.beer.order.service.web.models.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BeerOrderEvent {
    private BeerOrderDto beerOrderDto;
}
