package iamtomhewitt.clob.service;

import iamtomhewitt.clob.exception.GroupExistsException;
import iamtomhewitt.clob.exception.GroupNotFoundException;
import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.model.ChristmasList;
import iamtomhewitt.clob.model.Group;
import iamtomhewitt.clob.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ChristmasListService christmasListService;

    public List<String> getGroups() {
        return groupRepository.findAll()
                .stream()
                .map(Group::getName)
                .collect(toList());
    }

    public void createGroup(String name) throws GroupExistsException {
        Optional<Group> existingGroup = groupRepository.findByName(name);

        if (existingGroup.isPresent()) {
            throw new GroupExistsException(name);
        }

        Group group = Group.builder().name(name).build();
        groupRepository.save(group);
    }

    public void joinGroup(String email, String group) throws GroupNotFoundException, NoChristmasListException {
        ChristmasList list = christmasListService.getChristmasList(email);

        if (list.getGroups() == null) {
            list.setGroups(singletonList(group));
        } else {
            list.getGroups().add(group);
        }

        christmasListService.saveChristmasList(list);
    }

    public void leaveGroup(String email, String group) throws NoChristmasListException {
        ChristmasList list = christmasListService.getChristmasList(email);

        if (list.getGroups() != null) {
            list.getGroups().remove(group);
        }

        christmasListService.savecChristmasList(list);
    }
}
