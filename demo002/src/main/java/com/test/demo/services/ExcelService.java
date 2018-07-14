package com.test.demo.services;

import com.test.demo.domain.entities.Address;
import com.test.demo.domain.entities.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dyh
 * @create 2018-07-14 下午9:21
 * @desc excel测试类
 **/

@Service
public class ExcelService {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * 得到所有地址列表
     *
     * @return
     */
    public List<Address> findAll(){
        return addressRepository.findAll();
    }
}
