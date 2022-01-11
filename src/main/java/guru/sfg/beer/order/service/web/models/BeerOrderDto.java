package guru.sfg.beer.order.service.web.models;

import guru.sfg.beer.order.service.domain.OrderStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BeerOrderDto extends BaseItem {
    @Builder
    public BeerOrderDto(@Null UUID id, @Null Integer version, @Null OffsetDateTime createdAt, @Null OffsetDateTime lastModifiedAt, UUID customerId, String customerRef, String orderStatusCallbackUrl, OrderStatus status, List<BeerOrderLineDto> beerOrderLines) {
        super(id, version, createdAt, lastModifiedAt);
        this.customerId = customerId;
        this.customerRef = customerRef;
        this.orderStatusCallbackUrl = orderStatusCallbackUrl;
        this.status = status;
        this.beerOrderLines = beerOrderLines;
    }

    @NotNull
    private UUID customerId;
    @NotBlank
    private String customerRef;
    private String orderStatusCallbackUrl;
    @NotNull
    private OrderStatus status;
    private List<BeerOrderLineDto> beerOrderLines;
}
