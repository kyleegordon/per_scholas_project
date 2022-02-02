package org.perscholas.dependencyinjectionexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker1 {

//    public static final Logger LOG = LoggerFactory.getLogger(Worker1.class);
    public void doWork() {
//        LOG.warn ("this is worker 1");
        System.out.println("worker 1 doing work");

//        try{
//            int x= 1/0;
//        } catch (Exception e) {
//            LOG.error("\nThis is the message: ", e);
//        }
    }
}
