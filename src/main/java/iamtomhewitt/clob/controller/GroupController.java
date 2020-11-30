package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.GroupExistsException;
import iamtomhewitt.clob.exception.GroupNotFoundException;
import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.service.ChristmasListService;
import iamtomhewitt.clob.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin(origins = "http://localhost:3000")
public class GroupController {

    @Autowired
    private GroupService service;

    @Autowired
    private ChristmasListService christmasListService;

    @GetMapping("/all")
    public List<String> getGroups() {
        return service.getGroups();
    }

    @PostMapping
    public void createGroup(@RequestParam String name) throws GroupExistsException {
        service.createGroup(name);
    }

    @PutMapping
    private void joinGroup(@RequestParam String email, @RequestParam String name) throws NoChristmasListException, GroupNotFoundException {
        service.joinGroup(email, name);
    }
}

