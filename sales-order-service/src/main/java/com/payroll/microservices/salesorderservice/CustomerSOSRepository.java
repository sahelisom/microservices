package com.payroll.microservices.salesorderservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSOSRepository extends JpaRepository<Customer, Long> {

}
