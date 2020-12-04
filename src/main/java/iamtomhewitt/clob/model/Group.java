package iamtomhewitt.clob.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groups")
@Data
@Builder
@AllArgsConstructor
public class Group {
    private String name;

    public Group() {
    }
}
