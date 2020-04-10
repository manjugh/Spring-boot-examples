package org.spring.batch.db.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import oracle.ucp.UniversalConnectionPoolException;
import oracle.ucp.admin.UniversalConnectionPoolManagerImpl;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

@Configuration
@ConfigurationProperties("data-source")
public class DatasourceConfig {

	 //Do *NOT* use SQLForValidateConnection - bad for performance, Oracle has build in mech instead: https://docs.oracle.com/database/121/JJUCP/connect.htm#JJUCP8136
    private int     minPoolSize;
    private int     maxPoolSize;
    private int     initialPoolSize;
    private boolean validateConnectionOnBorrow    = true;
    private int     maxConnectionReuseTimeSec;
    private int     inactiveConnectionTimeoutSec;
    private int     abandonedConnectionTimeout;
    private int     timeToLiveConnectionTimeout;
    private int     connectionWaitTimeout;
    private String  onsConfiguration;
    private boolean fastConnectionFailoverEnabled = false;
    private int     maxStatements;

    private String user;
    private String password;
    private String url;
    private int    loginTimeout;
    private Long   readTimeoutMillis;

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public void setInitialPoolSize(int initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public void setValidateConnectionOnBorrow(boolean validateConnectionOnBorrow) {
        this.validateConnectionOnBorrow = validateConnectionOnBorrow;
    }

    public void setMaxConnectionReuseTimeSec(int maxConnectionReuseTimeSec) {
        this.maxConnectionReuseTimeSec = maxConnectionReuseTimeSec;
    }

    public void setInactiveConnectionTimeoutSec(int inactiveConnectionTimeoutSec) {
        this.inactiveConnectionTimeoutSec = inactiveConnectionTimeoutSec;
    }

    public void setAbandonedConnectionTimeout(int abandonedConnectionTimeout) {
        this.abandonedConnectionTimeout = abandonedConnectionTimeout;
    }

    public void setTimeToLiveConnectionTimeout(int timeToLiveConnectionTimeout) {
        this.timeToLiveConnectionTimeout = timeToLiveConnectionTimeout;
    }

    public void setConnectionWaitTimeout(int connectionWaitTimeout) {
        this.connectionWaitTimeout = connectionWaitTimeout;
    }

    public void setOnsConfiguration(String onsConfiguration) {
        this.onsConfiguration = onsConfiguration;
    }

    public void setFastConnectionFailoverEnabled(boolean fastConnectionFailoverEnabled) {
        this.fastConnectionFailoverEnabled = fastConnectionFailoverEnabled;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLoginTimeout(int loginTimeout) {
        this.loginTimeout = loginTimeout;
    }

    public void setReadTimeoutMillis(Long readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public void setMaxStatements(int maxStatements) {
        this.maxStatements = maxStatements;
    }

    @PreDestroy
    public void shutdown() throws UniversalConnectionPoolException {
        for (String poolName : UniversalConnectionPoolManagerImpl
                .getUniversalConnectionPoolManager()
                .getConnectionPoolNames()) {
            UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager().destroyConnectionPool(poolName);
        }
    }

    @Bean
    public DataSource dataSource() throws SQLException, UniversalConnectionPoolException {
        shutdown(); //needed after 12.0.2 - bug or feature - nevertheless...

        PoolDataSource poolDataSource = PoolDataSourceFactory.getPoolDataSource();
        poolDataSource.setConnectionPoolName("INVPOOL");
        poolDataSource.setConnectionFactoryClassName(OracleDataSource.class.getName());
        poolDataSource.setMinPoolSize(minPoolSize);
        poolDataSource.setMaxPoolSize(maxPoolSize);
        poolDataSource.setInitialPoolSize(initialPoolSize);
        poolDataSource.setValidateConnectionOnBorrow(validateConnectionOnBorrow);
        poolDataSource.setMaxConnectionReuseTime(maxConnectionReuseTimeSec);
        poolDataSource.setInactiveConnectionTimeout(inactiveConnectionTimeoutSec);
        poolDataSource.setAbandonedConnectionTimeout(abandonedConnectionTimeout);
        poolDataSource.setTimeToLiveConnectionTimeout(timeToLiveConnectionTimeout);
        poolDataSource.setConnectionWaitTimeout(connectionWaitTimeout);
        poolDataSource.setONSConfiguration(onsConfiguration);
        poolDataSource.setFastConnectionFailoverEnabled(fastConnectionFailoverEnabled);
        poolDataSource.setMaxStatements(maxStatements);
        poolDataSource.setValidateConnectionOnBorrow(true);
        poolDataSource.setSQLForValidateConnection("select 1 from dual");

        poolDataSource.setURL("jdbc:oracle:thin:@localhost:1521/orcl");
        poolDataSource.setUser("appdata");
        poolDataSource.setPassword("app");
        poolDataSource.setLoginTimeout(loginTimeout);

        Properties properties = new Properties();
        properties.put(OracleConnection.CONNECTION_PROPERTY_THIN_READ_TIMEOUT, readTimeoutMillis.toString());
        properties.put("DMSStatementMetrics", Boolean.TRUE.toString());
        properties.put("oracle.jdbc.DMSStatementMetrics", Boolean.TRUE.toString());
        poolDataSource.setConnectionProperties(properties);

        return poolDataSource;
    }

    @Bean
    @Primary
    @ConfigurationProperties("transaction-manager")
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
