package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.common.Constants;
import com.rabf.productservice.api.controller.model.client.ClientRequestDto;
import com.rabf.productservice.api.domain.Client;
import com.rabf.productservice.api.enums.EClientCategory;
import com.rabf.productservice.api.exception.InvalidClientCategoryException;
import com.rabf.productservice.api.exception.InvalidDateFormatException;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientRequestMapper {

    public ClientRequestMapper() {
    }

    public Client map(ClientRequestDto request) {
        Converter<ClientRequestDto, Client> converter = new Converter<ClientRequestDto, Client>() {
            @Override
            public Client convert(MappingContext<ClientRequestDto, Client> context) {
                ClientRequestDto clientRequestDto = context.getSource();
                Client client = new Client();

                DateFormat dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD_HH_MM_SS);
                try {
                    client.setBirthdate(dateFormat.parse(clientRequestDto.getBirthdate()));
                    client.setMemberSince(dateFormat.parse(clientRequestDto.getMemberSince()));
                } catch (ParseException e) {
                    throw new InvalidDateFormatException("Invalid date format for Client");
                }

                try {
                    client.setCategory(EClientCategory.valueOf(clientRequestDto.getCategory()));
                } catch (IllegalArgumentException e) {
                    throw new InvalidClientCategoryException("Invalid category - " + clientRequestDto.getCategory() + " -  for client");
                }

                client.setFirstname(clientRequestDto.getFirstname());
                client.setLastname(clientRequestDto.getLastname());
                return client;
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(ClientRequestDto.class, Client.class).setConverter(converter);
        return modelMapper.map(request, Client.class);
    }
}
