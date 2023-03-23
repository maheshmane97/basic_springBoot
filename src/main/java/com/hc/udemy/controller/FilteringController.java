package com.hc.udemy.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hc.udemy.entity.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public SomeBean getBean(){
        return new SomeBean("Mahesh","Mane","7744807198");
    }

    @GetMapping("/filterlist")
    public List<SomeBean> getAllBean(){
        return Arrays.asList(new SomeBean("Mahesh","Mane","7744807198"),
                new SomeBean("Suraj","Mane","7768942856"),
        new SomeBean("Aadesh","Chavan","7775988283"));
    }

    @GetMapping("/filterdynamically")
    public MappingJacksonValue getBeanDynamically(){
        SomeBean someBean = new SomeBean("Mahesh", "Mane", "7744807198");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
