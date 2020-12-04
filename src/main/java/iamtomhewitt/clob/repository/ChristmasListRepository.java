package iamtomhewitt.clob.repository;

import iamtomhewitt.clob.model.ChristmasList;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ChristmasListRepository extends MongoRepository<ChristmasList, String> {
    @Query(value = "{ 'belongsTo.email' : ?0 }")
    Optional<ChristmasList> findByEmail(String email);

    @DeleteQuery(value = "{ 'belongsTo.email' : ?0 }")
    void deleteByEmail(String email);
}
