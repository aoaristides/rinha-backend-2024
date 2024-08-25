package br.com.makersweb.makerspay.domain.repositories;

import br.com.makersweb.makerspay.domain.entity.Transaction;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author anderson
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCustomerIdOrderByCreatedAtDesc(final Long customerId, final Limit limit);

}
