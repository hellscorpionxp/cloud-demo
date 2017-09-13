package com.example;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Tony
 * @date 2017-08-09
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConfigClientApplication.class)
public class ConfigClientApplicationTest {

    @Resource
    private WebApplicationContext context;
    private MockMvc mock;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        mock = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * Test method for {@link com.example.ConfigClientApplication#index()}.
     *
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception {
        MvcResult result = mock.perform(MockMvcRequestBuilders.get("/"))
            .andDo(MockMvcResultHandlers.print()).andReturn();

        assertEquals(result.getResponse().getContentAsString(),
            "combined: true, passwd: kW2MdhdYkVodXVG9");
    }

}
