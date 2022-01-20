package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.domain.BeerOrder.BeerOrderBuilder;
import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.web.models.BeerOrderDto;
import guru.sfg.beer.order.service.web.models.BeerOrderDto.BeerOrderDtoBuilder;
import guru.sfg.beer.order.service.web.models.BeerOrderLineDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2022-01-14T15:20:13+0530",
        comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.11 (OpenLogic)"
)
@Component
public class BeerOrderMapperImpl implements BeerOrderMapper {

    @Autowired
    private DateMapper dateMapper;
    @Autowired
    private BeerOrderLineMapper beerOrderLineMapper;

    @Override
    public BeerOrderDto beerOrderToDto(BeerOrder beerOrder) {
        if (beerOrder == null) {
            return null;
        }

        BeerOrderDtoBuilder beerOrderDto = BeerOrderDto.builder();

        beerOrderDto.customerId(beerOrderCustomerId(beerOrder));
        beerOrderDto.id(beerOrder.getId());
        beerOrderDto.version(beerOrder.getVersion());
        beerOrderDto.createdAt(dateMapper.asOffsetDateTime(beerOrder.getCreatedAt()));
        beerOrderDto.lastModifiedAt(dateMapper.asOffsetDateTime(beerOrder.getLastModifiedAt()));
        beerOrderDto.orderStatusCallbackUrl(beerOrder.getOrderStatusCallbackUrl());
        beerOrderDto.status(beerOrder.getStatus());
        beerOrderDto.beerOrderLines(beerOrderLineSetToBeerOrderLineDtoList(beerOrder.getBeerOrderLines()));

        return beerOrderDto.build();
    }

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        if (dto == null) {
            return null;
        }

        BeerOrderBuilder beerOrder = BeerOrder.builder();

        beerOrder.id(dto.getId());
        beerOrder.version(dto.getVersion());
        beerOrder.createdAt(dateMapper.asTimeStamp(dto.getCreatedAt()));
        beerOrder.lastModifiedAt(dateMapper.asTimeStamp(dto.getLastModifiedAt()));
        beerOrder.status(dto.getStatus());
        beerOrder.orderStatusCallbackUrl(dto.getOrderStatusCallbackUrl());
        beerOrder.beerOrderLines(beerOrderLineDtoListToBeerOrderLineSet(dto.getBeerOrderLines()));

        return beerOrder.build();
    }

    private UUID beerOrderCustomerId(BeerOrder beerOrder) {
        if (beerOrder == null) {
            return null;
        }
        Customer customer = beerOrder.getCustomer();
        if (customer == null) {
            return null;
        }
        UUID id = customer.getId();
        if (id == null) {
            return null;
        }
        return id;
    }

    protected List<BeerOrderLineDto> beerOrderLineSetToBeerOrderLineDtoList(Set<BeerOrderLine> set) {
        if (set == null) {
            return null;
        }

        List<BeerOrderLineDto> list = new ArrayList<BeerOrderLineDto>(set.size());
        for (BeerOrderLine beerOrderLine : set) {
            list.add(beerOrderLineMapper.beerOrderLineToDto(beerOrderLine));
        }

        return list;
    }

    protected Set<BeerOrderLine> beerOrderLineDtoListToBeerOrderLineSet(List<BeerOrderLineDto> list) {
        if (list == null) {
            return null;
        }

        Set<BeerOrderLine> set = new HashSet<BeerOrderLine>(Math.max((int) (list.size() / .75f) + 1, 16));
        for (BeerOrderLineDto beerOrderLineDto : list) {
            set.add(beerOrderLineMapper.dtoToBeerOderLine(beerOrderLineDto));
        }

        return set;
    }
}
