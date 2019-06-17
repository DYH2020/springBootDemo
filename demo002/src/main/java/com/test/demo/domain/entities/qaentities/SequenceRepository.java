package com.test.demo.domain.entities.qaentities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 * Created by huangguoping.
 */
@Service
public class SequenceRepository {
    @Autowired
    EntityManager entityManager;

    public Integer gen(String tabName) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("get_sequence")
                .registerStoredProcedureParameter("flag_name", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("seq_id", Integer.class, ParameterMode.OUT)
                .setParameter("flag_name", tabName);
        storedProcedureQuery.execute();
        return (Integer) storedProcedureQuery.getOutputParameterValue("seq_id");
    }

    public Integer generateSn(String tag) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("generate_sn")
                .registerStoredProcedureParameter("flag_name", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("seq_id", Integer.class, ParameterMode.OUT)
                .setParameter("flag_name", tag);
        storedProcedureQuery.execute();
        return (Integer) storedProcedureQuery.getOutputParameterValue("seq_id");
    }
}
