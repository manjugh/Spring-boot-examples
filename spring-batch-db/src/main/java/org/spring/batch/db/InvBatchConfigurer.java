package org.spring.batch.db;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @see http://stackoverflow.com/questions/27403540/spring-batch-3-0-2-integration-with-spring-core-4-1-x-what-is-the-appropriate
 * @see org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
 * @see DefaultBatchConfigurer
 * @see org.springframework.batch.core.configuration.annotation.BatchConfigurer
 */
public class InvBatchConfigurer extends DefaultBatchConfigurer {

    private final DataSource dataSource;

   /* @Value("${jobRepository.isolationLevelForCreate}")
    private String isolationLevelForCreate;*/

    public InvBatchConfigurer(DataSource dataSource) {
        super(dataSource);
        this.dataSource = dataSource;
    }

    //Construct our own so we can control isolation level
    //http://stackoverflow.com/questions/22364432/spring-batch-ora-08177-cant-serialize-access-for-this-transaction-when-running
    @Override
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(getTransactionManager());
        jobRepositoryFactoryBean.setValidateTransactionState(true);
        jobRepositoryFactoryBean.setIsolationLevelForCreate("ISOLATION_DEFAULT");
        //jobRepositoryFactoryBean.setTablePrefix("TAX_BAT_");
        jobRepositoryFactoryBean.afterPropertiesSet();

        return jobRepositoryFactoryBean.getObject();
    }
}