package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.AccountExistsException;
import iamtomhewitt.clob.exception.AccountNotFoundException;
import iamtomhewitt.clob.model.Account;
import iamtomhewitt.clob.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public Account getAccount(@RequestParam String email) throws AccountNotFoundException {
        return service.getAccount(email);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) throws AccountExistsException {
        service.createAccount(account);
    }
}

