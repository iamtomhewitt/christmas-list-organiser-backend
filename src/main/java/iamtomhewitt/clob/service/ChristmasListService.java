package iamtomhewitt.clob.service;

import iamtomhewitt.clob.exception.NoChristmasListException;
import iamtomhewitt.clob.model.ChristmasList;
import iamtomhewitt.clob.repository.ChristmasListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveChristmasList(ChristmasList list) {
        christmasListRepository.deleteByBelongsTo(list.getBelongsTo());
        christmasListRepository.save(list);
    }
}
