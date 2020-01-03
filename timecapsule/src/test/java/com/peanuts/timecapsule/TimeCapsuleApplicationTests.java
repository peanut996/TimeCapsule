package com.peanuts.timecapsule;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peanuts.timecapsule.domain.User;
import com.peanuts.timecapsule.service.UserService;
import com.peanuts.timecapsule.web.AdminController;
import com.peanuts.timecapsule.web.CapsuleController;
import com.peanuts.timecapsule.web.UserController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

class TimeCapsuleApplicationTests {
    private MockMvc usermvc;
//    private MockMvc capsulemvc;
//    private MockMvc adminmvc;

    @BeforeEach
    public void setUp() throws Exception {
        usermvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
//        capsulemvc = MockMvcBuilders.standaloneSetup(new CapsuleController()).build();
//        adminmvc = MockMvcBuilders.standaloneSetup(new AdminController()).build();
}

    @Test
    public  void testUserController() throws  Exception{
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/user/");
        //get all user
        usermvc.perform(MockMvcRequestBuilders
                .get("/user/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        //post one user
        usermvc.perform(MockMvcRequestBuilders.get("/user/peanuts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        
    }
//    @Test
//    public  void testCapsuleService() throws Exception{
//
//    }



}
