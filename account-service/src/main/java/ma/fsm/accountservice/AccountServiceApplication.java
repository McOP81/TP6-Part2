package ma.fsm.accountservice;

import ma.fsm.accountservice.entities.BankAccount;
import ma.fsm.accountservice.enums.AccountType;
import ma.fsm.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
        return args -> {
          BankAccount bankAccount1 = BankAccount.builder()
                  .accountId(UUID.randomUUID().toString())
                  .currency("MAD")
                  .balance(98000)
                  .createAt(LocalDate.now())
                  .type(AccountType.CURRENT_ACCOUNT)
                  .customerId(Long.valueOf(1))
                  .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(120000)
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();
            accountRepository.save(bankAccount1);
            accountRepository.save(bankAccount2);
        };
    }
}
