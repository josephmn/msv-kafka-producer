package api.azure.msv_kafka_producer.presentation.controllers;

import api.azure.msv_kafka_producer.domain.entities.Customer;
import api.azure.msv_kafka_producer.domain.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer clientSave = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSave);
    }
}
