package br.com.makersweb.makerspay.services.impl;

import br.com.makersweb.makerspay.domain.repositories.CustomerRepository;
import br.com.makersweb.makerspay.domain.repositories.TransactionRepository;
import br.com.makersweb.makerspay.dto.response.extract.BalanceResponse;
import br.com.makersweb.makerspay.dto.response.extract.ExtractResponse;
import br.com.makersweb.makerspay.dto.response.extract.TransactionResponse;
import br.com.makersweb.makerspay.exceptions.CustomerNotFoundException;
import br.com.makersweb.makerspay.services.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

/**
 * @author anderson
 */
@Service
@AllArgsConstructor
@Slf4j
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    @Override
    public ExtractResponse extract(final Long id) {
        log.info("Extract Customer by id - {}", id);
        final var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException());

        return ExtractResponse.with(BalanceResponse.with(customer.getBalance(), customer.getFinancialLimit()),
                transactionRepository.findByCustomerIdOrderByCreatedAtDesc(id, Limit.of(10))
                        .stream().map(TransactionResponse::from).toList());
    }
}
