package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beer.model.BeerDto;
import guru.sfg.beer.order.service.services.beer.service.BeerService;
import guru.sfg.beer.order.service.services.beer.service.BeerServiceRestTemplate;
import guru.sfg.beer.order.service.web.controllers.NotFoundException;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public abstract class BeerOrderLineDecorator implements BeerOrderLineMapper {
    private BeerService beerService;
    private BeerOrderLineMapper mapper;

    @Autowired
    public void setBeerServiceRestTemplate(BeerService beerService) {
        this.beerService = beerService;
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
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) throws Exception {
        BeerOrderLineDto dto = mapper.beerOrderLineToDto(beerOrderLine);
        BeerDto beerDto = beerService.getBeerData(dto.getBeerId());
        dto.setBeerName(beerDto.getBeerName());
        dto.setUpc(beerDto.getUpc());
        dto.setBeerStyle(beerDto.getBeerStyle());
        dto.setPrice(beerDto.getPrice());
        return dto;
    }
}
