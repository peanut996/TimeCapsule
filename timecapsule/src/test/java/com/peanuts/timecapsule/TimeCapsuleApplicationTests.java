package com.peanuts.timecapsule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest

class TimeCapsuleApplicationTests {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() throws Exception {
          mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
}

    @Test
    public  void testUserController() throws  Exception {
        //get all user
        mvc.perform(MockMvcRequestBuilders
                .get("/user/"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //get one user
        mvc.perform(MockMvcRequestBuilders.get("/user/peanuts"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //post one user
        mvc.perform(MockMvcRequestBuilders.post("/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"username\": \"onepeanut\",\n" +
                        "        \"password\": \"123456\",\n" +
                        "        \"nickname\": \"Peanuts\",\n" +
                        "        \"email\": \"846471144@qq.com\",\n" +
                        "        \"createtime\": \"2019-12-31T16:00:00.000+0000\",\n" +
                        "        \"updatetime\": \"2020-01-01T15:59:59.000+0000\",\n" +
                        "        \"avatar\": \"https://sm.ms/avatar.img\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(equalTo("success")));

        //put user 'onepeanut'　to 'one'
        mvc.perform(MockMvcRequestBuilders.put("/user/onepeanut")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"username\": \"one\",\n" +
                        "        \"password\": \"123456\",\n" +
                        "        \"nickname\": \"Peanuts\",\n" +
                        "        \"email\": \"846471144@qq.com\",\n" +
                        "        \"createtime\": \"2019-12-31T16:00:00.000+0000\",\n" +
                        "        \"updatetime\": \"2020-01-01T15:59:59.000+0000\",\n" +
                        "        \"avatar\": \"https://sm.ms/avatar.img\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(equalTo("success")));

        //delete user 'one'
        mvc.perform(MockMvcRequestBuilders.delete("/user/one"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void testCapsuleController() throws Exception{
        //get all capsule
        mvc.perform(MockMvcRequestBuilders
                .get("/capsule/"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //get one capsule
        mvc.perform(MockMvcRequestBuilders.get("/capsule/0399b02e-c6ab-447c-b880-c9cdb91acb4f"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //post one capsule
        mvc.perform(MockMvcRequestBuilders.post("/capsule/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"content\": \"Try Everthing. \",\n" +
                        "        \"createtime\": \"2020-01-01T06:00:00.000+0000\",\n" +
                        "        \"opentime\": \"2020-02-01T06:00:00.000+0000\",\n" +
                        "        \"username\": \"user\",\n" +
                        "        \"uuid\": \"a58c3d08-c602-e421-a38f-5d72f9e04243\",\n" +
                        "        \"warncontent\": \"Stop! Bitch!\",\n" +
                        "        \"email\": \"849421294@qq.com\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(equalTo("success")));

        //put capsule content
        mvc.perform(MockMvcRequestBuilders.put("/capsule/a58c3d08-c602-e421-a38f-5d72f9e04243")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"content\": \"Just Do It. \",\n" +
                        "        \"createtime\": \"2020-01-01T06:00:00.000+0000\",\n" +
                        "        \"opentime\": \"2020-02-01T06:00:00.000+0000\",\n" +
                        "        \"username\": \"user\",\n" +
                        "        \"uuid\": \"a58c3d08-c602-e421-a38f-5d72f9e04243\",\n" +
                        "        \"warncontent\": \"Stop! Bitch!\",\n" +
                        "        \"email\": \"849421294@qq.com\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(equalTo("success")));

        //delete user 'one'
        mvc.perform(MockMvcRequestBuilders.delete("/capsule/a58c3d08-c602-e421-a38f-5d72f9e04243"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(content().string(equalTo("success")));





    }

    @Test
    public  void testAdminController() throws  Exception {
        //get all admin
        mvc.perform(MockMvcRequestBuilders
                .get("/admin/"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //get one admin
        mvc.perform(MockMvcRequestBuilders.get("/admin/peanuts"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //post one admin
        mvc.perform(MockMvcRequestBuilders.post("/admin/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"account\": \"admin\",\n" +
                        "        \"password\": \"849421294\",\n" +
                        "        \"description\": \"administartors for the whole project\",\n" +
                        "        \"avatar\": \"https://sm.ms/avatar.img\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(equalTo("success")));

        //put admin 'admin'　to 'one'
        mvc.perform(MockMvcRequestBuilders.put("/admin/admin")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"account\": \"one\",\n" +
                        "        \"password\": \"849421294\",\n" +
                        "        \"description\": \"administartors for the whole project\",\n" +
                        "        \"avatar\": \"https://sm.ms/avatar.img\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(equalTo("success")));

        //delete admin 'one'
        mvc.perform(MockMvcRequestBuilders.delete("/admin/one"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(content().string(equalTo("success")));
    }




}
