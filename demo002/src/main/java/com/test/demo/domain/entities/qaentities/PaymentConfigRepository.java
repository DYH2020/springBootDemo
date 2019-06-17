package com.test.demo.domain.entities.qaentities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentConfigRepository extends JpaRepository<PaymentConfig, Integer> {
    /**
     * 根据支付代码查询
     * @param payCode
     * @return
     */
    @Query(value = "Select * From payment_config where pay_code = ? limit 1;", nativeQuery = true)
    public PaymentConfig findByPayCode(String payCode);

    /**
     * 查找特约商户
     * @param appId
     * @param mchId
     * @return
     */
    @Query(value = "SELECT * FROM payment_config WHERE appid = ? AND mch_id = ? LIMIT 1", nativeQuery = true)
    public PaymentConfig findMch(String appId, String mchId);

    /**
     * 查找服务商
     * @param appId
     * @param mchId
     * @param subAppId
     * @param subMchId
     * @return
     */
    @Query(value = "SELECT * FROM payment_config WHERE appid = ? AND mch_id = ? AND sub_appid = ? AND sub_mch_id = ? LIMIT 1", nativeQuery = true)
    public PaymentConfig findSubMch(String appId, String mchId, String subAppId, String subMchId);

    /**
     *
     * @param mchId
     * @return
     */
    @Query(value = "SELECT * FROM payment_config WHERE mch_id = ? AND (sub_mch_id is null OR sub_mch_id = '') LIMIT 1", nativeQuery = true)
    public PaymentConfig findByMchId(String mchId);

    /**
     *
     * @param mchId
     * @param subMchId
     * @return
     */
    @Query(value = "SELECT * FROM payment_config WHERE mch_id = ? AND sub_mch_id = ? LIMIT 1", nativeQuery = true)
    public PaymentConfig findByMchIdAndSubMchId(String mchId, String subMchId);

}
