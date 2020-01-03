package com.peanuts.timecapsule;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peanuts.timecapsule.domain.User;
import com.peanuts.timecapsule.service.UserService;
import com.peanuts.timecapsule.web.UserController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TimeCapsuleApplicationTests {
    private MockMvc mvc;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
}

    @Test
    public  void testUserService() throws  Exception{
        
    }



}
