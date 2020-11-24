package iamtomhewitt.clob.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@Builder
@AllArgsConstructor
public class Account {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public Account() {}
}
