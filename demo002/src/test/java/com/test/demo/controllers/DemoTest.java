package com.test.demo.controllers;

import com.test.demo.Main;
import com.test.demo.domain.entities.Address;
import com.test.demo.domain.entities.AddressRepository;
import com.test.demo.services.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)//扫描启动类
public class DemoTest {

    @Autowired
	private AddressRepository addressRepository;

    @Autowired
    private DemoController demoController;

    @Autowired
    private DemoService demoService;

    /**
     * 查找地址
     * 访问addressRepository层
     */
	@Test
	public void query() {
		System.out.println("===访问addressRepository层====");
		List<Address> lst = addressRepository.queryListByName("%我%");

		System.out.println(lst.size());

		if (lst.size() > 0) {
			for (Address ad : lst) {
				System.out.println(ad.toString());
			}
		}
	}

	/**
	 * 查找地址，访问controller层
	 */
    @Test
    public void queryAddress(){
        System.out.println("===访问controller层====");
        String str = demoController.demo("%我%");
        System.out.println(str);
    }

    /**
     * 查找地址，访问service层
     */
    @Test
    public void queryServiceAddress(){
        System.out.println("===访问service层====");
        List<Address> lst = demoService.queryAddress("%我%");
        System.out.println(lst.size());

        if (lst.size() > 0) {
            for (Address ad : lst) {
                System.out.println(ad.toString());
            }
        }
    }

}