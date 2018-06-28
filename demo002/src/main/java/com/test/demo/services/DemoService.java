package com.test.demo.services;

import com.test.demo.domain.entities.Address;
import com.test.demo.domain.entities.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * 根据名称查找地区
     * @param name
     * @return
     */
    public List<Address> queryAddress(String name){
        return addressRepository.queryListByName(name);
    }


    public Address findById(int id){
        return addressRepository.findOne(id);
    }

    public Address updateName(int id, String address){
        Address a = addressRepository.findOne(id);
        if (a!=null){
            a.setAddress(address);
            addressRepository.save(a);
            return a;
        }else
            return null;
    }

}
