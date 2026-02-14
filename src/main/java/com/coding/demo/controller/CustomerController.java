package com.coding.demo.controller;

import com.coding.demo.model.Customer;
import com.coding.demo.service.CustomerService;
import com.coding.demo.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final EmailService emailService;

    @Value("${email.id}")
    private String emailTo;

    @Value("${email.subject}")
    private String subject;

    @PostMapping("/")
    public Customer persistCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteById(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        customerService.deleteById(id);
        return customer.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/email/{id}")
    public ResponseEntity<String> sendMail(@PathVariable String id) {
        try {
            List<Customer> cust = customerService.getAllCustomer();
            emailService.sendMail(emailTo, subject, cust.toString());
            return ResponseEntity.ok("Mail has been sent to pradnya");
        } catch (Exception e) {
            log.error("Error encountered while sending mail for id {}", id, e);
            return ResponseEntity.internalServerError().build();
        }

    }


}
