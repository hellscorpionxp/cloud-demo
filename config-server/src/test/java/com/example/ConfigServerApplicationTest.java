package com.example;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConfigServerApplication.class, properties = "local.server.port=8888")
public class ConfigServerApplicationTest {

    @Value("${local.server.port}")
    private int port = 0;

    @Test
    public void envPostAvailable() {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = new TestRestTemplate().postForEntity(
            "http://localhost:" + port + "/config/env", form, Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}
