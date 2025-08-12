package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext{

    private static TestPostRepository testPostRepository;
    private static TestPostService testPostService;

    static {
        testPostRepository = new TestPostRepository();
        testPostService = new TestPostService(testPostRepository);
    }

    public ApplicationContext() {

    }

    public <T> T genBean(String beanName) {
        if(beanName.equals("testPostRepository")){
            return (T) testPostRepository;
        }
        else if(beanName.equals("testPostService")) {
            return (T) testPostService;
        }
        return null;
    }
}
