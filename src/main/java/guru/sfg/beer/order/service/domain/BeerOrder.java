package guru.sfg.beer.order.service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerOrder extends BaseEntity {

    @Builder
    public BeerOrder(UUID id, Integer version, Timestamp createdAt, Timestamp lastModifiedAt, Customer customer, OrderStatus status, String orderStatusCallbackUrl, Set<BeerOrderLine> beerOrderLines) {
        super(id, version, createdAt, lastModifiedAt);
        this.customer = customer;
        this.status = status;
        this.orderStatusCallbackUrl = orderStatusCallbackUrl;
        this.beerOrderLines = beerOrderLines;
    }

    @ManyToOne
    private Customer customer;

    private OrderStatus status = OrderStatus.NEW;
    private String orderStatusCallbackUrl;

    @OneToMany(mappedBy = "beerOrder", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<BeerOrderLine> beerOrderLines;
}
