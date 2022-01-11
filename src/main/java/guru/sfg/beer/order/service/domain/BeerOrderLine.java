package guru.sfg.beer.order.service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerOrderLine extends BaseEntity {
    @ManyToOne
    private BeerOrder beerOrder;

    private Integer orderQuantity;
    private Integer quantityAllocated;
    private UUID beerId;
    private String upc;

    @Builder
    public BeerOrderLine(UUID id, Integer version, Timestamp createdAt, Timestamp lastModifiedAt, BeerOrder beerOrder, Integer orderQuantity, Integer quantityAllocated, UUID beerId, String upc) {
        super(id, version, createdAt, lastModifiedAt);
        this.beerOrder = beerOrder;
        this.orderQuantity = orderQuantity;
        this.quantityAllocated = quantityAllocated;
        this.beerId = beerId;
        this.upc = upc;
    }
}
