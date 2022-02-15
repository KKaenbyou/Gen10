package corbos.fieldagent.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Agent {

    @Id
    private String identifier;
    
    @NotBlank(message = "First name must not be empty.")
    @Size(max = 25, message="First name must be less than 25 characters.")
    private String firstName;
    
    @Size(max = 25, message="First name must be less than 25 characters.")
    private String middleName;
    
    @NotBlank(message = "Last name must not be empty.")
    @Size(max = 25, message="Last name must be less than 25 characters.")
    private String lastName;
    
    private String pictureUrl;
    
    private LocalDate birthDate;
    
    @Min(value = 36, message = "Height should not be less than 36")
    @Max(value = 96, message = "Height should not be greater than 96")
    private int height;
        
    private LocalDate activationDate;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "security_clearance_id")
    private SecurityClearance securityClearance;
}
