package pl.akademiakodu.shops.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;


    private String description;
    private boolean cheap;
    private Double price;

    // OnToOne sprawia, że będzie tworzony klucz obcy o nazwie shop_id, który będazie odnosił się do tabeli shop

    @OneToOne
    private Shop shop;

    @Override
    public String toString(){
        return getDescription();
    }

}
