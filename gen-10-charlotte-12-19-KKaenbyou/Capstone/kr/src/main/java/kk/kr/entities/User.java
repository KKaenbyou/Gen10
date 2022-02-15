package kk.kr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
    
    @Id
    @NotBlank(message = "Username must not be empty.")
    @Size(max = 20, message="First name must be less than 20 characters.")
    private String username;
    
    private String realname;
    
    @NotBlank(message = "Password must not be empty.")
    private String password;
    
    int points;
}
