package com.onchain;

import com.onchain.config.ParamsConfig;
import com.onchain.utils.InetAddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@EnableAsync
@SpringBootApplication
@EnableScheduling
public class SynhandlerApplication {

    @Autowired
    private ParamsConfig paramsConfig;

    @Bean(name = "synTaskExecutor")
    public AsyncTaskExecutor taskExecutor() {
        log.info("########synTaskExecutor#########");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(paramsConfig.THREADPOOLSIZE_MAX);
        executor.setCorePoolSize(paramsConfig.THREADPOOLSIZE_CORE);
        executor.setQueueCapacity(paramsConfig.THREADPOOLSIZE_QUEUE);
        executor.setThreadNamePrefix("TxHandlerThread--");
        executor.setKeepAliveSeconds(paramsConfig.THREADPOOLSIZE_KEEPALIVE_SECOND);
        //调用者的线程会执行该任务,如果执行器已关闭,则丢弃
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SynhandlerApplication.class, args);
    }
}
