package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.web.models.BeerOrderDto;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BeerOrderMapperTest extends TestCase {

    @Mock
    private BeerOrderMapper mapper;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    public void testBeerOrderToDto() {
        // given
        Set<BeerOrderLine> beerOrderLines = new HashSet<>();
        beerOrderLines.add(new BeerOrderLine());
        beerOrderLines.add(new BeerOrderLine());
        beerOrderLines.add(new BeerOrderLine());

        BeerOrder beerOrder = BeerOrder.builder()
                .id(UUID.randomUUID())
                .beerOrderLines(beerOrderLines)
                .build();

        // when
        BeerOrderDto dto = mapper.beerOrderToDto(beerOrder);

        // then
        assertEquals(dto.getBeerOrderLines().size(),3);
    }

    public void testDtoToBeerOrder() {
    }
}