package br.com.makersweb.makerspay.domain.repositories;

import br.com.makersweb.makerspay.domain.entity.Customer;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.hibernate.LockOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.Optional;

/**
 * @author anderson
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "javax.persistence.lock.timeout", value =  LockOptions.SKIP_LOCKED + "") // LockOptions.SKIP_LOCKED == -2
    })
    Optional<Customer> findById(final Long id);

}
