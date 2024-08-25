package br.com.makersweb.makerspay.services.impl;

import br.com.makersweb.makerspay.domain.entity.Transaction;
import br.com.makersweb.makerspay.domain.repositories.CustomerRepository;
import br.com.makersweb.makerspay.dto.enums.TransactionType;
import br.com.makersweb.makerspay.dto.request.TransactionRequest;
import br.com.makersweb.makerspay.dto.response.transaction.TransactionResponse;
import br.com.makersweb.makerspay.exceptions.CustomerLimitExcededException;
import br.com.makersweb.makerspay.exceptions.CustomerNotFoundException;
import br.com.makersweb.makerspay.services.TransactionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author anderson
 */
@Service
@AllArgsConstructor
@Slf4j
public class DefaultTransactionService implements TransactionService {

    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public TransactionResponse transaction(final Long id, final TransactionRequest request) {
        log.info("Init method transaction by id - {}", id);
        final var customer = customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        if (TransactionType.CREDITO.equals(request.type())) {
            customer.increaseBalance(request.value());
        } else {
            if (customer.getBalance() - request.value() < -customer.getFinancialLimit()) {
                throw new CustomerLimitExcededException();
            }
            customer.decreaseBalance(request.value());
        }

        Transaction transaction = Transaction.builder()
                .type(request.type().getValue())
                .customer(customer)
                .amount(request.value())
                .description(request.description())
                .createdAt(Instant.now())
                .build();

        customer.addTransaction(transaction);
        customerRepository.save(customer);

        return TransactionResponse.with(customer.getFinancialLimit(), customer.getBalance());
    }
}
