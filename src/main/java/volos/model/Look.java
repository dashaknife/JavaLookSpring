package volos.model;

import lombok.*;
import volos.model.enums.Brand;
import volos.model.enums.Color;
import volos.model.enums.Size;
import volos.model.enums.TypeOfClothes;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "look")
public class Look {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    private TypeOfClothes typeOfClothes;

    public Look (String name, double price, Size s, Color c, Brand b, TypeOfClothes type) {
        this.name = name;
        this.price = price;
        this.size = s;
        this.color = c;
        this.brand = b;
    }

}
