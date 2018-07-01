package com.test.demo.controllers;

import com.test.demo.domain.entities.Address;
import com.test.demo.domain.entities.AddressRepository;
import com.test.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private AddressRepository addressRepository;

    /**
     * RequestParam 参数里面的name和value的效果是一样的
     * RequestMapping 参数里面就只能是value了，
     * @param name
     * @return
     */
    @RequestMapping(value = "/demo")
    public String demo(@RequestParam(name = "name")String name, @RequestParam(value = "id")int id){
        return "hello "+ name+"\t"+id;
    }

    /**
     * RequestParam 参数里面的name和value的效果是一样的
     * RequestMapping 参数里面就只能是value了，
     * @param name
     * @return
     */
    @RequestMapping(value = "/queryaddress")
    public String demo(@RequestParam(name = "name")String name){
        List<Address> addressList = demoService.queryAddress("%"+name+"%");
        System.out.println(addressList.toString());

        //不建议在controller层直接调用addressRepository，虽然同样能够达到效果，
        //List<Address> addressList2 = addressRepository.queryListByName("%"+name+"%");
        //System.out.println(addressList2.toString());

        return addressList.toString();
        //return "wolaile";
    }


    /**
     * 查找
     * @param id
     * @return
     */
    @RequestMapping("/query")
    public String query(@RequestParam(name = "id")int id){
        Address a =  demoService.findById(id);
        return a==null?"没有符合查找的东西":a.toString();
    }

    /**
     * 查找
     * @param id
     * @return
     */
    @RequestMapping("/update")
    public String query(@RequestParam(name = "id")int id,@RequestParam(name = "address")String address){
        Address a =  demoService.updateName(id,address);
        return  a==null?"什么也没有":a.toString();
    }



}
