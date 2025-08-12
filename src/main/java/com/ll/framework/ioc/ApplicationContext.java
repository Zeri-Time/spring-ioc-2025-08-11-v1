package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext{


    public ApplicationContext() {

    }

    public TestPostService genBean(String beanName) {
        return new TestPostService(new TestPostRepository());
    }
}
