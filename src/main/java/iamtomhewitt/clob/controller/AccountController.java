package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.AccountExistsException;
import iamtomhewitt.clob.exception.AccountNotFoundException;
import iamtomhewitt.clob.exception.InvalidAccountException;
import iamtomhewitt.clob.model.Account;
import iamtomhewitt.clob.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public Account getAccount(@RequestParam String email) throws AccountNotFoundException {
        return service.getAccount(email);
    }

    @GetMapping("/validate")
    public Account validateAccount(@RequestParam String email, @RequestParam String password) throws AccountNotFoundException, InvalidAccountException {
        return service.validateAccount(email, password);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) throws AccountExistsException, AccountNotFoundException {
        service.createAccount(account);
    }
}

