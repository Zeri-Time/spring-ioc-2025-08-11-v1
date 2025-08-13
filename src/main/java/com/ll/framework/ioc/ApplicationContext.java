package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final Map<String, Object> bean;

    private final TestPostRepository testPostRepository = new TestPostRepository();
    private final TestPostService testPostService = new TestPostService(testPostRepository);
    private final TestFacadePostService testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);

    public ApplicationContext() {
        this.bean = new HashMap<>();

        bean.put("testPostRepository", testPostRepository);
        bean.put("testPostService", testPostService);
        bean.put("testFacadePostService", testFacadePostService);
    }

    public <T> T genBean(String beanName) {
        return (T) bean.get(beanName);
    }
}
