package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private Integer numberOfFaces;
    private Integer currentFaceValue;

    public Die(Integer numFaces){
        this.numberOfFaces = numFaces;
    }

    public void roll(){
        ThreadLocalRandom randomNumberGenerator = ThreadLocalRandom.current();
        Integer randomFaceValue = randomNumberGenerator.nextInt(1,numberOfFaces);
        this.currentFaceValue = randomFaceValue;

    }

    public Integer getNumberOfFaces() {
        return numberOfFaces;
    }

    public Integer getCurrentFaceValue() {
        return currentFaceValue;
    }
}
