package volos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import volos.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Look> looks = new LinkedList<>();

    public Order (User user, OrderStatus s) {
        this.user = user;
        this.status = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        for (int i = 0; i < looks.size(); i++) {
            if(!Objects.equals(looks.get(i), order.looks.get(i)))
                return false;
        }
        return Objects.equals(id, order.id) && Objects.equals(user, order.user) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, status, looks);
    }
}
