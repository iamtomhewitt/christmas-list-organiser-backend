package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.AccountNotFoundException;
import iamtomhewitt.clob.exception.ItemNotFoundException;
import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.model.Account;
import iamtomhewitt.clob.model.ChristmasList;
import iamtomhewitt.clob.service.AccountService;
import iamtomhewitt.clob.service.ChristmasListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/christmas-list")
@CrossOrigin(origins = "http://localhost:3000")
public class ChristmasListController {

    @Autowired
    private ChristmasListService service;

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ChristmasList getChristmasList(@RequestParam String email) throws NoChristmasListException {
        return service.getChristmasList(email);
    }

    @GetMapping("/all")
    public List<ChristmasList> getAllChristmasLists() {
        return service.getAllChristmasLists();
    }

    @PostMapping
    public ChristmasList saveChristmasList(@RequestBody ChristmasList list) {
        return service.saveChristmasList(list);
    }

    @PutMapping
    public ChristmasList dibItem(@RequestParam String itemName, @RequestParam String listOwner, @RequestParam String dibbedBy) throws NoChristmasListException, ItemNotFoundException, AccountNotFoundException {
        Account account = accountService.getAccount(dibbedBy);
        return service.dibItem(itemName, listOwner, account);
    }
}

