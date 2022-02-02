package org.perscholas.dependencyinjectionexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//component annotation tells spring to look for any classes with specific annotations
//1st pass
@Component
public class Manager {
    //first spring creates its context, where it will put all objects that it is going to create
    //context is like a bucket to hold the objects it creates, and we can ask for the objects
    //later with @ AutoWired
    //spring makes 3 pass when it first starts

    //1st pass: Component scan, finds all spring classes with an annotation (ex, @Controller,
    //@Component, @Repository) and creates an instance of this class

    //2nd pass: all @Autowired, this is done in the 2nd pass because objects need to be created
    //before they can be Autowired

    //WARNING: in spring, you CANNOT use constructors to initialize the class if it is using an
    //@Autowired variable, this is because on pass 1 when it is creating the instances of all
    // the classes, it has not yet autowired the variables in

    //3rd pass: runs all @PostConstruct methods



    //autowired allows these components to be used without including them in the constructor
    //2nd pass
    @Autowired
    private Worker1 worker1;

    @Autowired
    private Worker2 worker2;

    @Autowired
    private Worker3 worker3;

    public Manager() {

        //These lines of code would fail since spring will not have autowired the variables
        // on the first pass when this code will be attempted
        //it is not good practice to use the constructor with spring component for this reason
//        worker1.doWork();
//        worker2.doWork();
//        worker3.doWork();

    }

    //3rd pass
    @PostConstruct
    public void init() {
        worker1.doWork();
        worker2.doWork();
        worker3.doWork();

    }


}
