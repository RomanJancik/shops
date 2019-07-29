package pl.akademiakodu.shops.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.shops.model.Comment;
import pl.akademiakodu.shops.model.Shop;
import pl.akademiakodu.shops.repository.ShopRepository;

@Controller
public class ShopController {

    /*Shop repos... to interfejs z 11 metodami min, save findAll
     * fabryka springa szuka beana, który implementyje interdejs ShopRepository
     * NIe znajduje go. bIerze generacje beana na siebie, generuje klasę z implementacjami tych metod
     * */

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/")
    public String home(ModelMap map) {
        map.put("shops", shopRepository.findAll());
        map.put("shop", new Shop());
        return "home";
    }

    @PostMapping("/shops")
    public String create(@ModelAttribute Shop shop) {
        shopRepository.save(shop);
        return "redirect:/";
    }

    @GetMapping("/shops/{id}")
    public String show(@PathVariable Integer id, ModelMap map) {
        Shop shop = shopRepository.findById(id).get();
        map.put("shop", shopRepository.findById(id).get());
        map.put("shop", shop);
        Comment comment = new Comment();
        comment.setShop(shop);
        map.put("comment", comment);

        return "show";

    }

    @GetMapping("/search")
    public String search(@RequestParam String name, ModelMap redirectAttributes ){
        redirectAttributes.addAttribute("shops",shopRepository.findShopsByName(name));
        if(shopRepository.findShopsByName(name).size()>0)
            redirectAttributes.addAttribute("message", "Znalezione sklepy");
        else
            redirectAttributes.addAttribute("message", "Nie znaleziono sklepu");
        redirectAttributes.put("shop", new Shop());
        return "home";
    }



}
