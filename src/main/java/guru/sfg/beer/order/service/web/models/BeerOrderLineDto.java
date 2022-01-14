package guru.sfg.beer.order.service.web.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BeerOrderLineDto extends BaseItem {
    @Builder
    public BeerOrderLineDto(@Null UUID id, @Null Integer version, @Null OffsetDateTime createdAt, @Null OffsetDateTime lastModifiedAt, Integer orderQuantity, UUID beerId, String beerName, String upc, String beerStyle, BigDecimal price) {
        super(id, version, createdAt, lastModifiedAt);
        this.orderQuantity = orderQuantity;
        this.beerId = beerId;
        this.beerName = beerName;
        this.upc = upc;
        this.beerStyle = beerStyle;
        this.price = price;
    }

    private Integer orderQuantity;
    private UUID beerId;
    private String beerName;
    private String beerStyle;
    private String upc;
    private BigDecimal price;
}
