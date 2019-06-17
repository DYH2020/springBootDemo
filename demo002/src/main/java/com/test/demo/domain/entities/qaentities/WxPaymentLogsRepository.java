package com.test.demo.domain.entities.qaentities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WxPaymentLogsRepository extends JpaRepository<WxPaymentLogs, Integer> {

    /**
     * 根据id查找微信支付日志记录
     * @param id id
     * @return 记录
     */
    @Query(value = "Select * From wx_payment_logs where id = ? limit 1;", nativeQuery = true)
    public WxPaymentLogs findById(int id);
}
