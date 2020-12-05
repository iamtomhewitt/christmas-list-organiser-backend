package iamtomhewitt.clob.controller;

import iamtomhewitt.clob.exception.GroupExistsException;
import iamtomhewitt.clob.exception.GroupNotFoundException;
import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.service.ChristmasListService;
import iamtomhewitt.clob.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/group")
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
    public ResponseEntity<Map<String, String>> createGroup(@RequestParam String name) throws GroupExistsException {
        service.createGroup(name);
        return new ResponseEntity<>(createSuccessBody(), HttpStatus.OK);
    }

    @PutMapping("/join")
    private ResponseEntity<Map<String, String>> joinGroup(@RequestParam String email, @RequestParam String name) throws NoChristmasListException, GroupNotFoundException {
        service.joinGroup(email, name);
        return new ResponseEntity<>(createSuccessBody(), HttpStatus.OK);
    }

    @PutMapping("/leave")
    private ResponseEntity<Map<String, String>> leaveGroup(@RequestParam String email, @RequestParam String name) throws NoChristmasListException {
        service.leaveGroup(email, name);
        return new ResponseEntity<>(createSuccessBody(), HttpStatus.OK);
    }

    private Map<String, String> createSuccessBody() {
        Map<String, String> body = new HashMap<>();
        body.put("status", "ok");
        return body;
    }
}

