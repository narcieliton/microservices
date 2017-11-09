package com.narcielitonlopes.professor.resource;

import org.apache.coyote.Response;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/professores")
public class ProfessoreResource {


    @RequestMapping(method = RequestMethod.GET)
    public void listar(){
       System.out.println("lista de professores");

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity.get(URI.create("http://localhost:8081/alunos")).build();

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);


        System.out.println("---------------");

        System.out.println(response.getBody());
    }



}
