package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLine dtoToBeerOderLine(BeerOrderLineDto beerOrderLineDto);

    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine);
}
