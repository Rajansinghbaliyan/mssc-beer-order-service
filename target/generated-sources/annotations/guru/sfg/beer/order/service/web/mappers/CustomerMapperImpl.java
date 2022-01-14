package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.Customer;
import guru.sfg.beer.order.service.domain.Customer.CustomerBuilder;
import guru.sfg.beer.order.service.web.models.CustomerDto;
import guru.sfg.beer.order.service.web.models.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-12T09:49:04+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.11 (OpenLogic)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public Customer dtoToCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.id( dto.getId() );
        customer.version( dto.getVersion() );
        customer.createdAt( dateMapper.asTimeStamp( dto.getCreatedAt() ) );
        customer.lastModifiedAt( dateMapper.asTimeStamp( dto.getLastModifiedAt() ) );

        return customer.build();
    }

    @Override
    public CustomerDto customerToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.id( customer.getId() );
        customerDto.version( customer.getVersion() );
        customerDto.createdAt( dateMapper.asOffsetDateTime( customer.getCreatedAt() ) );
        customerDto.lastModifiedAt( dateMapper.asOffsetDateTime( customer.getLastModifiedAt() ) );

        return customerDto.build();
    }
}
