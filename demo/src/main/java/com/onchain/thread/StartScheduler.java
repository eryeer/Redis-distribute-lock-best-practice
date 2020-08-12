package com.onchain.thread;

import com.onchain.lock.DistributedLockAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Component
public class StartScheduler {

    @DistributedLockAnnotation("lock1")
    @Scheduled(cron = "0/6 * * * * *")
    public void startScheduler() throws Exception {
        log.info("Staring scheduler");
        log.info("finish scheduler");

    }
}
