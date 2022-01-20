package guru.sfg.beer.order.service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Builder
    public Customer(UUID id, Integer version, Timestamp createdAt, Timestamp lastModifiedAt, String customerName, UUID apiKey, Set<BeerOrder> beerOrders) {
        super(id, version, createdAt, lastModifiedAt);
        this.customerName = customerName;
        this.apiKey = apiKey;
        this.beerOrders = beerOrders;
    }

    private String customerName;
    private UUID apiKey;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<BeerOrder> beerOrders;
}
