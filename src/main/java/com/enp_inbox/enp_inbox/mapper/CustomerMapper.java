package com.enp_inbox.enp_inbox.mapper;

import com.enp_inbox.enp_inbox.dto.CustomerDTO;
import com.enp_inbox.enp_inbox.entity.CustomerEntity;

public class CustomerMapper {

    // Convert CustomerEntity to CustomerDto
    public CustomerDTO toDto(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        CustomerDTO customerDto = new CustomerDTO();
        customerDto.setId(customerEntity.getId());
        customerDto.setName(customerEntity.getCustomerName());
        customerDto.setEmail(customerEntity.getEmails());
        customerDto.setPhoneNumber(customerEntity.getMobile());
        // If you have fields like audit fields (createdDate, createdBy, etc.)
/*        customerDto.setCreateDate(customerEntity.getCreatedDate());
        customerDto.setCreatedBy(customerEntity.getCreatedBy());
        customerDto.setUpdateDate(customerEntity.getLasModifiedDate());
        customerDto.setUpdatedBy(customerEntity.getLastModifiedBy());*/

        return customerDto;
    }

}
