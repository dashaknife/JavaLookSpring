package volos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role_user")
public class RoleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String name;
    private int levelAccess;

    public RoleUser (String name, int levelAccess) {
        this.name = name;
        this.levelAccess = levelAccess;
    }
}
