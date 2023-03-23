package com.hc.udemy.controller;

import com.hc.udemy.entity.Name;
import com.hc.udemy.entity.PersonV1;
import com.hc.udemy.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping("/person/v1")
    public PersonV1 getPersonV1(){
        PersonV1 v1 = new PersonV1("Mahesh Mane");
        System.out.println(v1+" ########");
        return v1;
    }

    @GetMapping("/person/v2")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("Mahesh","Mane"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1ByReqParam(){
        PersonV1 v1 = new PersonV1("Mahesh Mane");
        System.out.println(v1+" ########");
        return v1;
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2ByReqParam(){
        return new PersonV2(new Name("Mahesh","Mane"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1ByHeader(){
        PersonV1 v1 = new PersonV1("Mahesh Mane");
        System.out.println(v1+" ########");
        return v1;
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2ByHeader(){
        return new PersonV2(new Name("Mahesh","Mane"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.api-v1+json")
    public PersonV1 getPersonV1ByAcceptHeader(){
        PersonV1 v1 = new PersonV1("Mahesh Mane");
        System.out.println(v1+" ########");
        return v1;
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.api-v2+json")
    public PersonV2 getPersonV2ByAcceptHeader(){
        return new PersonV2(new Name("Mahesh","Mane"));
    }
}
