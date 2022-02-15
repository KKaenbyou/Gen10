package kk.kr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int total;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "foodOrderBridge",
            joinColumns = {
                @JoinColumn(name = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "food")})
    private List<Food> food;
}
