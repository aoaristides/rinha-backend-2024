package br.com.makersweb.makerspay.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * @author anderson
 */
@Getter
@Entity(name = "Transaction")
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, length = 1)
    private String type;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    private Instant createdAt;

}
