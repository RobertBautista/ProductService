package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.model.client.ClientRequest;
import com.rabf.productservice.api.dto.ClientDto;
import com.rabf.productservice.api.enums.EClientCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientRequestMapperTest {

    @Test
    public void a() {
        String name = "Juan";
        String lastName = "Perez";
        ClientRequest cr = ClientRequest.builder().
                firstname(name).
                lastname(lastName).
                birthdate("1980-10-10 11:00:00").
                memberSince("2010-10-10 11:00:00").
                category("GOLD").
                build();

        ClientRequestMapper clientRequestMapper = new ClientRequestMapper();
        ClientDto resp = clientRequestMapper.map(cr);
        Assertions.assertNotNull(resp);
        Assertions.assertEquals(name, resp.getFirstname());
        Assertions.assertEquals(lastName, resp.getLastname());
        Assertions.assertEquals(EClientCategory.GOLD, resp.getCategory());
    }
}
