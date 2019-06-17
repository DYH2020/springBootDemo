package com.test.demo.domain.entities.qaentities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order getOrderByOrderNo(String orderNo);

    @Query(value = "select * from orders where business_id = ? and order_type = ? and deleted = 0 order by create_time desc", nativeQuery = true)
    Order getOrder(int businessId, int type);

    @Query(value = "select * from orders where (user_id = ? or patient_mobile = ?) and order_type != 6 and deleted = 0 order by create_time desc", nativeQuery = true)
    List<Order> getOrderListByUserId(int userId, String mobile);

    @Query(value = "select * from orders where id = ? and deleted = 0 limit 1;", nativeQuery = true)
    Order getOrderById(int id);

    /**
     * 根据问诊（咨询）id得到订单对象
     *
     * @param doctorId
     * @param countId
     * @return
     */
    @Query(value = "select * from orders where doctor_id = ? and business_id = ? and order_type = 5 and deleted = 0 limit 1;", nativeQuery = true)
    Order findOrderByCountId(int doctorId, int countId);

    /**
     * 获取待结算的远程会诊订单
     *
     * @return
     */
    @Query(value = "select * from orders where order_status = 80 and order_type = 1 and deleted = 0 order by id;", nativeQuery = true)
    List<Order> getTreatmentOrderList();


    /**
     * 根据hisOrderNo得到订单
     *
     * @param hisOrderNo
     * @return
     */
    @Query(value = " select o.* from orders o left JOIN outpatient_order oo on  o.business_id = oo.id and o.order_type = 8 and oo.deleted = 0 and o.deleted = 0  where oo.his_order_no = ? order by oo.id desc limit 1 ;", nativeQuery = true)
    Order getOneByHisOrderNo(String hisOrderNo);

    /**
     * 根据business_id获取订单
     * @param businessId business_id
     * @return {@link Order}
     */
    @Query(value = "select * from orders where business_id = ? and deleted = 0 limit 1;", nativeQuery = true)
    Order getOrderByBusinessId(int businessId);

    /**
     * 获取指定日期的账单
     * @param startDate
     * @param endDate
     * @return
     */
    @Query(value = "Select * from orders where `payment_status` = 2 and `payment_no` is not null and `pay_time` >= ? and `pay_time` <= ?", nativeQuery = true)
    List<Order> getBill(Date startDate, Date endDate);
}
