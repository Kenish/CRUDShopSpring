package com.projectmaking.Controller;

import com.projectmaking.Model.Product;
import com.projectmaking.Service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavouritesController {
    private FavouritesService favouritesService;
    @Autowired
    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @RequestMapping(value = "api/users/favourite/{ProductId}",method = RequestMethod.POST)
    HttpStatus addFavouriteProduct(@PathVariable("ProductId")Long productId){
        return favouritesService.addProductToList(productId);
    }

    @RequestMapping(value = "api/users/favourite",method = RequestMethod.GET)
    List<Product> getFavourites(){
       return favouritesService.showAllProductsInList();
    }

    @RequestMapping(value = "api/users/favourite/{ProductId}",method = RequestMethod.DELETE)
    HttpStatus removeFavouriteProduct(@PathVariable("ProductId")Long productId){
       return favouritesService.removeProductFromList(productId);
    }
}
