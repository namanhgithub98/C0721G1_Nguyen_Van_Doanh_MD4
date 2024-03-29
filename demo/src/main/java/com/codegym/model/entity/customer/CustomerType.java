package com.codegym.model.entity.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTypeId;
    private String customerTypeName;


    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(Integer customerTypeId, String customerTypeName) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
