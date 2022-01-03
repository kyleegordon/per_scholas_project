package com.company.dietest;

import com.company.Die;
import org.junit.Assert;
import org.junit.Test;

public class RollTest {
    private void test(Integer numberOfFaces) {
        //given
        Integer unexpected = null;
        Die die = new Die(numberOfFaces);

        //when
        die.roll();
        Integer actual = die.getCurrentFaceValue();

        //then
        Assert.assertNotEquals(unexpected, actual);

    }

    @Test
    public void test0() { test(2);}

    @Test
    public void test1() { test(3);}

    @Test(expected = NullPointerException.class)
    public void test2() { test(null);}


}
