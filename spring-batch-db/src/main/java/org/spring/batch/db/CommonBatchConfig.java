package org.spring.batch.db;

import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.StepScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Common configuration across batch-jobs.
 */
//@EnableBatchProcessing
@ComponentScan
public abstract class CommonBatchConfig {

    //http://stackoverflow.com/questions/28457107/spring-batch-scope-issue-while-using-spring-boot
    @Bean
    public static StepScope stepScope() {
        StepScope stepScope = new StepScope();
        stepScope.setAutoProxy(true);
        stepScope.setProxyTargetClass(true);

        return stepScope;
    }

    @Bean
    public JobParametersIncrementer jobParametersIncrementer() {
        return new RunIdIncrementer();
    }

}