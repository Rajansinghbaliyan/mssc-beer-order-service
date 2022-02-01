package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.web.controllers.NotFoundException;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.springframework.web.client.HttpClientErrorException;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(value = BeerOrderLineDecorator.class)
public interface BeerOrderLineMapper {
    BeerOrderLine dtoToBeerOderLine(BeerOrderLineDto beerOrderLineDto);

    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) throws Exception;
}
