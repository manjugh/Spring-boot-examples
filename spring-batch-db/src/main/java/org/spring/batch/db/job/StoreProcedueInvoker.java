package org.spring.batch.db.job;

import java.sql.Array;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleConnection;

@Component
public class StoreProcedueInvoker {

	@Autowired
	DataSource dataSource;
	
	public void invokeCmcInterestRateChangeStatisticsProcedure(List<String> orgIds) {
        try {
            SqlParameter sqlParameter = new SqlParameter("PI_ORGID", Types.ARRAY, "T_PREPARE_IRC_REQUESTS");
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("PROC_REPORT_IRC")
                                                                          .withoutProcedureColumnMetaDataAccess()
                                                                          .declareParameters(sqlParameter);
            Map<String, Object> procedureParameters = new HashMap<>();
            procedureParameters.put("PI_ORGID", prepareCmcInterestRateChangeInputParameter(orgIds, dataSource));
            String errorMessage = simpleJdbcCall.executeObject(String.class, procedureParameters);
            System.out.println("errorMessage "+errorMessage);
        } catch (Exception exception) {
           exception.printStackTrace();
        }
        
    }
	
	private Array prepareCmcInterestRateChangeInputParameter(List<String> orgIds, DataSource dataSource) throws SQLException {
        try (OracleConnection oracleConnection =  (OracleConnection) dataSource.getConnection()){
            Object[] orgIdArray = new Object[2];
            Struct[] orgIdStruct = new Struct[orgIds.size()];
            for (int i = 0; i < orgIds.size(); i++) {
                orgIdArray[0] = orgIds.get(i);
                orgIdArray[1] = null;
                orgIdStruct[i] = oracleConnection.createStruct("T_PREPARE_IRC_REQUEST", orgIdArray);
            }
            return oracleConnection.createOracleArray("T_PREPARE_IRC_REQUESTS", orgIdStruct);
        } 
    }
}
