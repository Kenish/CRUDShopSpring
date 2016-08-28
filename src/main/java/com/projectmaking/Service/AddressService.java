package com.projectmaking.Service;

import com.projectmaking.Model.Address;
import com.projectmaking.Model.User;
import com.projectmaking.Repository.AddressRepository;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private UserManagementService userManagementService;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository,UserManagementService userManagementService) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.userManagementService = userManagementService;
    }

    public List<Address> getAddresses(){
        User user = userManagementService.getUser();
        return user.getAddresses();
    }

    public HttpStatus addAddress(Address address){
        User user = userManagementService.getUser();
        user.addAdress(address);
        addressRepository.save(address);
        userRepository.saveAndFlush(user);
        addressRepository.flush();
        return HttpStatus.CREATED;
    }

    public HttpStatus removeAddress(Long id){
        User user = userManagementService.getUser();
        Address address= addressRepository.findOne(id);

        if (userHaveRights(user,address)){
            user.getAddresses().remove(address);
            userRepository.saveAndFlush(user);
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.BAD_REQUEST;
    }

    public HttpStatus setCurrentAddress(Long id){
        User user = userManagementService.getUser();
        List<Address> addresses =   user.getAddresses();
        addresses.forEach(address -> address.setActive(false));
        Address address = addressRepository.findOne(id);
        if (userHaveRights(user,address)) {
            address.setActive(true);
            userRepository.save(user);
            addressRepository.saveAndFlush(address);
            userRepository.flush();
            return HttpStatus.ACCEPTED;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    private boolean userHaveRights(User user,Address address){
        return user.getAddresses().contains(address);
    }
}
