package guru.sfg.beer.order.service.web.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OrderStatusUpdate extends BaseItem {
    @Builder
    public OrderStatusUpdate(@Null UUID id, @Null Integer version, @Null OffsetDateTime createdAt, @Null OffsetDateTime lastModifiedAt, UUID orderId, String customerRef, String orderStatus) {
        super(id, version, createdAt, lastModifiedAt);
        this.orderId = orderId;
        this.customerRef = customerRef;
        this.orderStatus = orderStatus;
    }

    private UUID orderId;
    private String customerRef;
    private String orderStatus;
}
