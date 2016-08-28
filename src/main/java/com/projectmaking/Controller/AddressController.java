package com.projectmaking.Controller;

import com.projectmaking.Model.Address;
import com.projectmaking.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @RequestMapping(value = "api/users/addresses",method = RequestMethod.GET)
    List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @RequestMapping(value = "api/users/addresses",method = RequestMethod.POST)
    HttpStatus addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @RequestMapping(value = "api/users/addresses/{id}",method = RequestMethod.POST)
    HttpStatus setCurrentAddress(@PathVariable Long id){
        return addressService.setCurrentAddress(id);
    }

    @RequestMapping(value = "api/users/addresses/{id}",method = RequestMethod.DELETE)
    HttpStatus deleteAddress(@PathVariable Long id){
        return addressService.removeAddress(id);
    }

}
