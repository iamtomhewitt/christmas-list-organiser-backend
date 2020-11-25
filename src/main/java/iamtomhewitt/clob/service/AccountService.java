package iamtomhewitt.clob.service;

import iamtomhewitt.clob.exception.AccountExistsException;
import iamtomhewitt.clob.exception.AccountNotFoundException;
import iamtomhewitt.clob.exception.InvalidAccountException;
import iamtomhewitt.clob.model.Account;
import iamtomhewitt.clob.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String email) throws AccountNotFoundException {
        Optional<Account> account = accountRepository.findByEmail(email);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(email);
        }

        return account.get();
    }

    public void createAccount(Account account) throws AccountExistsException {
        Optional<Account> existingAccount = accountRepository.findByEmail(account.getEmail());

        if (existingAccount.isPresent()) {
            throw new AccountExistsException(account.getEmail());
        }

        accountRepository.save(account);
    }

    public Account validateAccount(String email, String password) throws AccountNotFoundException, InvalidAccountException {
        Optional<Account> account = accountRepository.findByEmail(email);

        if (!account.isPresent()) {
            throw new AccountNotFoundException(email);
        }

        if (!account.get().getPassword().equals(password)) {
            throw new InvalidAccountException(email);
        }

        return account.get();
    }
}
