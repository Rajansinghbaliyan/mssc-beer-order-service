package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import guru.sfg.beer.order.service.services.beer.service.BeerServiceRestTemplate;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BeerOrderLineDecorator implements BeerOrderLineMapper {
    private BeerServiceRestTemplate beerServiceRestTemplate;
    private BeerOrderLineMapper mapper;

    @Autowired
    public void setBeerServiceRestTemplate(BeerServiceRestTemplate beerServiceRestTemplate) {
        this.beerServiceRestTemplate = beerServiceRestTemplate;
    }

    @Autowired
    public void setMapper(BeerOrderLineMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerOrderLine dtoToBeerOderLine(BeerOrderLineDto beerOrderLineDto) {
        return mapper.dtoToBeerOderLine(beerOrderLineDto);
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) {
        BeerOrderLineDto dto = mapper.beerOrderLineToDto(beerOrderLine);
        BeerDto beerDto = beerServiceRestTemplate.getBeerData(dto.getBeerId());
        dto.setBeerName(beerDto.getBeerName());
        dto.setUpc(beerDto.getUpc());
        dto.setBeerStyle(beerDto.getBeerStyle());
        dto.setPrice(beerDto.getPrice());
        return dto;
    }
}
