package com.projectmaking;

import com.projectmaking.Controller.UserController;
import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class Testing {
    @InjectMocks
    private UserController uc;

    @Mock
    private UserRepository repository;

    @Before
    public void init(){MockitoAnnotations.initMocks(this);}
    @Test
    public void testUserGet(){
        User user=new User();
        user.setId(1L);
        when(repository.findOne(1L)).thenReturn(user);
        User usr = uc.get(1L);
        assertThat(usr.getId(),is(1L));
    }

}
