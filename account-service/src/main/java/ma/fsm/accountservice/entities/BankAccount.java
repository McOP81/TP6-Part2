package ma.fsm.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.fsm.accountservice.enums.AccountType;
import ma.fsm.accountservice.model.Customer;

import java.time.LocalDate;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
