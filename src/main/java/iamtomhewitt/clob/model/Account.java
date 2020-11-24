package iamtomhewitt.clob.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@Builder
@AllArgsConstructor
public class Account {
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;

    public Account() {}
}
