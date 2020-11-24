package iamtomhewitt.clob.repository;

import iamtomhewitt.clob.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByUsername(String username);
}