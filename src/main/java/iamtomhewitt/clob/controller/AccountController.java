package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.AccountExistsException;
import iamtomhewitt.clob.exception.AccountNotFoundException;
import iamtomhewitt.clob.exception.InvalidAccountException;
import iamtomhewitt.clob.model.Account;
import iamtomhewitt.clob.model.ChristmasList;
import iamtomhewitt.clob.service.AccountService;
import iamtomhewitt.clob.service.ChristmasListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyList;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private ChristmasListService christmasListService;

    @GetMapping
    public Account getAccount(@RequestParam String email) throws AccountNotFoundException {
        return service.getAccount(email);
    }

    @GetMapping("/validate")
    public Account validateAccount(@RequestParam String email, @RequestParam String password) throws AccountNotFoundException, InvalidAccountException {
        return service.validateAccount(email, password);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createAccount(@RequestBody Account account) throws AccountExistsException, AccountNotFoundException {
        service.createAccount(account);

        ChristmasList list = ChristmasList.builder()
                .belongsTo(account)
                .groups(emptyList())
                .items(emptyList())
                .build();
        christmasListService.saveChristmasList(list);
        return new ResponseEntity<>(createSuccessBody(), HttpStatus.OK);
    }

    private Map<String, String> createSuccessBody() {
        Map<String, String> body = new HashMap<>();
        body.put("status", "ok");
        return body;
    }
}

