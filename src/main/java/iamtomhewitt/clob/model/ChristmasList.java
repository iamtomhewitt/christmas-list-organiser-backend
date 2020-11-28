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
    private String belongsTo;
    private List<ChristmasListItem> items;

    public ChristmasList() {}
}
