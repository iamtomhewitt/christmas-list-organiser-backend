package iamtomhewitt.clob.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("accounts")
@Data
@Builder
@AllArgsConstructor
public class Account {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public Account() {
    }
}
