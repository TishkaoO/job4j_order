package ru.job4j.app.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.CustomerDto;
import ru.job4j.app.entity.CustomerEntity;
import ru.job4j.app.mapper.CustomerMapper;
import ru.job4j.app.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository personRepository;
    private final CustomerMapper customerMapper;

    public CustomerDto save(CustomerEntity customer) {
        CustomerEntity builder = CustomerEntity.builder()
                .username(customer.getUsername())
                .password(customer.getPassword())
                .phoneNumber(customer.getPhoneNumber())
                .build();
        CustomerEntity registered = personRepository.save(builder);
        return customerMapper.toDto(registered);
    }
}
