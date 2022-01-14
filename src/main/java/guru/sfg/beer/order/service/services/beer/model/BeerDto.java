package guru.sfg.beer.order.service.services.beer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import guru.sfg.beer.order.service.web.models.BaseItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BeerDto extends BaseItem {
    @NotBlank
    private String beerName;

    @NotNull
    @Positive
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    @NotNull
    private String beerStyle;

    @NotBlank
    private String upc;

    private Integer quantityOnHand;
}