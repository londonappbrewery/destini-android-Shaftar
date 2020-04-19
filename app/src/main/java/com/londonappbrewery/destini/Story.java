package com.londonappbrewery.destini;

public class Story {

    private int[][] storyID;

    public Story(int storyID, int firstAnswer, int secondAnswer){
        this.storyID = new int[][]{
                {storyID, firstAnswer, secondAnswer},
                {storyID, firstAnswer, secondAnswer},
                {storyID, firstAnswer, secondAnswer},
                {storyID, firstAnswer, secondAnswer}
        };
    }

    public int getStoryID(int index1, int index2) {
        return storyID[index1][index2];
    }

    public void setStoryID(int index1, int index2, int storyID) {
        this.storyID[index1][index2] = storyID;
    }
}
