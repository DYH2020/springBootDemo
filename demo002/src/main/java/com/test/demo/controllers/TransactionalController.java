package com.test.demo.controllers;

import com.test.demo.domain.entities.Address;
import com.test.demo.services.TransactionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/transaction")
@RequestMapping({"/transaction"})
public class TransactionalController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionalController.class);

    @Autowired
    private TransactionalService transactionalService;

    /**
     * @return
     */
    @RequestMapping(value = "/updateTest")
    public String demo() {
        Address address = null;
        try {
            address = transactionalService.findById(4);
            System.out.println("修改之前：" + address.getAddress());
            address = transactionalService.updateName(4, "这里是修改之后的数据");
            System.out.println("修改之后：" + address.getAddress());
        } catch (Exception e) {
            logger.error(e.getMessage());
            Address localAddress = transactionalService.findById(4);
            System.out.println("再次去数据库查找：" + localAddress.getAddress());
        }
        return "";
    }
}
