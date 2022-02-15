package kk.kr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Food {

    @Id
    private String foodname;
    
    private int price;
    
    private String description;
    
    
    @ManyToMany(mappedBy = "food")
    @JsonIgnore
    private List<Order> order;
}
