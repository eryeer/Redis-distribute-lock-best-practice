package com.onchain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("ParamsConfig")
public class ParamsConfig {

    @Value("${threadPoolSize.max}")
    public int THREADPOOLSIZE_MAX;

    @Value("${threadPoolSize.core}")
    public int THREADPOOLSIZE_CORE;

    @Value("${threadPoolSize.queue}")
    public int THREADPOOLSIZE_QUEUE;

    @Value("${threadPoolSize.keepalive}")
    public int THREADPOOLSIZE_KEEPALIVE_SECOND;

}