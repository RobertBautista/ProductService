package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.common.Constants;
import com.rabf.productservice.api.controller.model.client.ClientRequest;
import com.rabf.productservice.api.domain.dto.ClientDto;
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

    public ClientDto map(ClientRequest request) {
        Converter<ClientRequest, ClientDto> converter = new Converter<ClientRequest, ClientDto>() {
            @Override
            public ClientDto convert(MappingContext<ClientRequest, ClientDto> context) {
                ClientRequest clientRequest = context.getSource();
                ClientDto clientDto = new ClientDto();

                DateFormat dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD_HH_MM_SS);
                try {
                    clientDto.setBirthdate(dateFormat.parse(clientRequest.getBirthdate()));
                    clientDto.setMemberSince(dateFormat.parse(clientRequest.getMemberSince()));
                } catch (ParseException e) {
                    throw new InvalidDateFormatException("Invalid date format for Client");
                }

                try {
                    clientDto.setCategory(EClientCategory.valueOf(clientRequest.getCategory()));
                } catch (IllegalArgumentException e) {
                    throw new InvalidClientCategoryException("Invalid category - " + clientRequest.getCategory() + " -  for client");
                }

                clientDto.setFirstname(clientRequest.getFirstname());
                clientDto.setLastname(clientRequest.getLastname());
                return clientDto;
            }
        };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(ClientRequest.class, ClientDto.class).setConverter(converter);
        return modelMapper.map(request, ClientDto.class);
    }
}
