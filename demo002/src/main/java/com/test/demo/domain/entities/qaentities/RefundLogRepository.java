package com.test.demo.domain.entities.qaentities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RefundLogRepository extends JpaRepository<RefundLog, Integer> {
    @Query(value = "SELECT * FROM refund_log WHERE transaction_id = ? LIMIT 1", nativeQuery = true)
    public RefundLog findByTransactionId(String transactionId);

    @Query(value = "SELECT * FROM refund_log WHERE refund_no = ? LIMIT 1", nativeQuery = true)
    public RefundLog findByRefundNo(String refundNo);
}
