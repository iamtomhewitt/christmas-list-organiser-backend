package iamtomhewitt.clob.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("lists")
@Data
@Builder
@AllArgsConstructor
public class ChristmasList {
    private Account belongsTo;
    private List<ChristmasListItem> items;
    private List<String> groups;

    public ChristmasList() {
    }
}
