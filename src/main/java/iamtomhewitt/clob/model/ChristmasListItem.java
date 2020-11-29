package iamtomhewitt.clob.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ChristmasListItem {
    private String name;
    private Account dibbedBy;
    private boolean dibbed;

    public ChristmasListItem() {
    }
}
