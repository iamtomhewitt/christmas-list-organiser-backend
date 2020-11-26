package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.model.ChristmasList;
import iamtomhewitt.clob.service.ChristmasListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/christmas-list")
@CrossOrigin(origins = "http://localhost:3000")
public class ChristmasListController {

    @Autowired
    private ChristmasListService service;

    @GetMapping
    public ChristmasList getChristmasList(@RequestParam String email) throws NoChristmasListException {
        return service.getChristmasList(email);
    }

    @PostMapping
    public ChristmasList saveChristmasList(@RequestBody ChristmasList list) {
        return service.saveChristmasList(list);
    }
}

