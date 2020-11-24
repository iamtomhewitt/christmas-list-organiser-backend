package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.model.Account;
import iamtomhewitt.clob.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingList")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public Account getAccount(String username) {
        return service.getAccount();
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) {
        service.createAccount();
    }
}

