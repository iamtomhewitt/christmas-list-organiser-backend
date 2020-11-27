package iamtomhewitt.clob.repository;

import iamtomhewitt.clob.model.ChristmasList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChristmasListRepository extends MongoRepository<ChristmasList, String> {
    Optional<ChristmasList> findByBelongsTo(String belongsTo);
    void deleteByBelongsTo(String belongsTo);
}
