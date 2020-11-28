package iamtomhewitt.clob.service;

import iamtomhewitt.clob.exception.ItemNotFoundException;
import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.model.ChristmasList;
import iamtomhewitt.clob.model.ChristmasListItem;
import iamtomhewitt.clob.repository.ChristmasListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChristmasListService {

    @Autowired
    private ChristmasListRepository christmasListRepository;

    public ChristmasList getChristmasList(String email) throws NoChristmasListException {
        Optional<ChristmasList> christmasList = christmasListRepository.findByBelongsTo(email);
        if (!christmasList.isPresent()) {
            throw new NoChristmasListException(email);
        }

        return christmasList.get();
    }

    public List<ChristmasList> getAllChristmasLists() {
        return christmasListRepository.findAll();
    }

    public ChristmasList saveChristmasList(ChristmasList list) {
        christmasListRepository.deleteByBelongsTo(list.getBelongsTo());
        christmasListRepository.save(list);
        return list;
    }

    public ChristmasList dibItem(String itemName, String belongsTo, String dibbedBy) throws NoChristmasListException, ItemNotFoundException {
        ChristmasList currentList = getChristmasList(belongsTo);

        Optional<ChristmasListItem> optionalItem = currentList.getItems()
                .stream()
                .filter(i -> i.getName().equals(itemName))
                .findFirst();

        if(!optionalItem.isPresent()) {
            throw new ItemNotFoundException(itemName);
        }

        ChristmasListItem item = optionalItem.get();
        item.setDibbed(true);
        item.setDibbedBy(dibbedBy);

        this.saveChristmasList(currentList);

        return currentList;
    }
}
