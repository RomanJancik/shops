package pl.akademiakodu.shops.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.akademiakodu.shops.model.Shop;

import java.util.List;

//extends CrudRepository dodaje metody pozwalające działac na bazie mysql

public interface ShopRepository extends CrudRepository<Shop, Integer> {

    @Query(value = "SELECT * FROM shop s WHERE s.name= :name", nativeQuery = true)
    List<Shop> findShopsByName(@Param("name") String name);
}
