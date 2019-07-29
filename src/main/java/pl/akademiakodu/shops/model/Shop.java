package pl.akademiakodu.shops.model;


import lombok.AllArgsConstructor; //konstruktor 1 ze wszystkimi parametrami
import lombok.Data; //getery setery, equals, hashcode
import lombok.NoArgsConstructor; //tworzy pusty konstruktor shop jeśli nie istnieje

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// @entity w bazie doanych tworzy tabelę o nazwie shop

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Shop {

    /*GENERATEDVALUEtworzy klucz główny, gdzie id będzie w sposób automatyczny generowane za nas.
    * każdy kolejny id jest większy o 1 niż poprzedni
    *
    *
    * */
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)


    private Integer id; // Integer ma NULL, integer ma 0

    //w bazie danych mamy kolumne name
    private String name;
    //w bazie danych mamy kolumne address
    private String address;


    //to pole nie jest tworzone jako kolumna w bazie danych
    @Transient
    private String description;

    @Override
    public String toString(){
        return name+" "+address;
    }

    @OneToMany(mappedBy = "shop")
    private List<Comment> comments = new ArrayList<>();


}
