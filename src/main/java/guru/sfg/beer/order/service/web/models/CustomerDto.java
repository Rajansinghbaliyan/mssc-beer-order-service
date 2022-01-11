package guru.sfg.beer.order.service.web.models;

import lombok.*;

import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CustomerDto extends BaseItem {
    @Builder
    public CustomerDto(@Null UUID id, @Null Integer version, @Null OffsetDateTime createdAt, @Null OffsetDateTime lastModifiedAt, String name) {
        super(id, version, createdAt, lastModifiedAt);
        this.name = name;
    }

    private String name;
}
