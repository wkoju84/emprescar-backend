package br.com.emprescar.service;

import br.com.emprescar.dto.CustomerDto;
import br.com.emprescar.dto.UserDto;
import br.com.emprescar.model.Customer;
import br.com.emprescar.model.User;
import br.com.emprescar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public CustomerDto insert(CustomerDto dto) {
        UserDto userDto =  userService.insert(dto.getUser());
        dto.setUser(userDto);
        Customer entity = copyDtoToEntity(dto, new Customer());
        entity = customerRepository.save(entity);

        return new CustomerDto(entity);
    }


    private Customer copyDtoToEntity(CustomerDto dto, Customer entity) {
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());

        User user = new User();
        user.setId(dto.getUser().getId());
        entity.setUser(user);
        return entity;
    }

}
