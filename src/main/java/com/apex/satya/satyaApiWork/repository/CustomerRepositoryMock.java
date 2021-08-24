package com.apex.satya.satyaApiWork.repository;

import com.apex.satya.satyaApiWork.entity.Customer;

import java.util.HashMap;

public class CustomerRepositoryMock {
    public static final HashMap<Integer, Customer> customers = new HashMap<>();;
    static {

        customers.put(100, new Customer(100,"Tango"));
        customers.put(101, new Customer(101,"Charlie"));

    }

    public static Customer getCustomerById(Integer customerId){
        return customers.get(customerId);
    }

}
