package com.test.demo.services;

import com.test.demo.domain.entities.Address;
import com.test.demo.domain.entities.AddressRepository;
import com.test.demo.utils.Checker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 事物相关测试业务
 */
@Service
public class TransactionalService {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * 根据名称查找地区
     *
     * @param name
     * @return
     */
    public List<Address> queryAddress(String name) {
        return addressRepository.queryListByName(name);
    }


    /**
     * 根据ID找到对象
     *
     * @param id
     * @return
     */
    public Address findById(int id) {
        return addressRepository.findOne(id);
    }

    /**
     * 修改地区名称
     *
     * @param id
     * @param address
     * @return
     */
    @Transactional
    public Address updateName(int id, String address) {
        Address a = addressRepository.findOne(id);
        if (!Checker.isNone(a)) {
            a.setAddress(address);
            addressRepository.save(a);
            System.out.println("修改之后：" + a.getAddress());
            if (true) {
                throw new RuntimeException("这里抛出异常啦");
            }
            return a;
        }
        return null;
    }

}
