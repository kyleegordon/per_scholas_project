package com.company.dietest;

import com.company.Die;
import org.junit.Test;
import org.junit.Assert;

public class ConstructorTest {

    public void test(Integer expectedNumFaces){
        //given
        Integer expectedFaceValue = null;


        //when
        Die die = new Die(expectedNumFaces);
        Integer actualFaceValue = die.getCurrentFaceValue();
        Integer actualNumberOfFaces = die.getNumberOfFaces();

        //then
        Assert.assertEquals(expectedFaceValue,actualFaceValue);
        Assert.assertEquals(expectedNumFaces,actualNumberOfFaces);
    }

    @Test
    public void test0(){
        test(3);
    }
    @Test
    public void test1(){
        test(4);
    }
    @Test
    public void test2(){
        test(6);
    }
}
