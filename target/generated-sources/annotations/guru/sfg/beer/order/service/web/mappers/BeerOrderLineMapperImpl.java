package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.domain.BeerOrderLine.BeerOrderLineBuilder;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto.BeerOrderLineDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-11T22:10:17+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.11 (OpenLogic)"
)
@Component
public class BeerOrderLineMapperImpl implements BeerOrderLineMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerOrderLine dtoToBeerOderLine(BeerOrderLineDto beerOrderLineDto) {
        if ( beerOrderLineDto == null ) {
            return null;
        }

        BeerOrderLineBuilder beerOrderLine = BeerOrderLine.builder();

        beerOrderLine.id( beerOrderLineDto.getId() );
        beerOrderLine.version( beerOrderLineDto.getVersion() );
        beerOrderLine.createdAt( dateMapper.asTimeStamp( beerOrderLineDto.getCreatedAt() ) );
        beerOrderLine.lastModifiedAt( dateMapper.asTimeStamp( beerOrderLineDto.getLastModifiedAt() ) );
        beerOrderLine.orderQuantity( beerOrderLineDto.getOrderQuantity() );
        beerOrderLine.beerId( beerOrderLineDto.getBeerId() );
        beerOrderLine.upc( beerOrderLineDto.getUpc() );

        return beerOrderLine.build();
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) {
        if ( beerOrderLine == null ) {
            return null;
        }

        BeerOrderLineDtoBuilder beerOrderLineDto = BeerOrderLineDto.builder();

        beerOrderLineDto.id( beerOrderLine.getId() );
        beerOrderLineDto.version( beerOrderLine.getVersion() );
        beerOrderLineDto.createdAt( dateMapper.asOffsetDateTime( beerOrderLine.getCreatedAt() ) );
        beerOrderLineDto.lastModifiedAt( dateMapper.asOffsetDateTime( beerOrderLine.getLastModifiedAt() ) );
        beerOrderLineDto.orderQuantity( beerOrderLine.getOrderQuantity() );
        beerOrderLineDto.beerId( beerOrderLine.getBeerId() );
        beerOrderLineDto.upc( beerOrderLine.getUpc() );

        return beerOrderLineDto.build();
    }
}
