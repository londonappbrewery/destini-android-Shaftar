package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyText;
    private Button buttonTop, buttonBottom;
    private int counterTop = 0, counterBottom = 0, step = 1;
    private boolean endOfStory = false;
    private Story[] story = new Story[]{
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End, R.string.T5_End, R.string.T6_End)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCounterTop(getCounterTop() + 1);
                nextStep();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCounterBottom(getCounterBottom() + 1);
                nextStep();

            }
        });
    }

    private void nextStep(){
        // setCounter(getCounter()% story.length);
        // First Level
        // To show question 3 and its answers
        if (getCounterTop() == 1 && !isEndOfStory()){
            storyText.setText(getStoryID(2, 0));
            buttonTop.setText(getStoryID(2, 1));
            buttonBottom.setText(getStoryID(2, 2));
            setStep(getStep()+1);
            setEndOfStory(false);
            // Next Level
        } else if (getCounterTop() == 2 && !isEndOfStory()) {
            storyText.setText(getStoryID(3, 2));
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
            setEndOfStory(true);
        } else if (getCounterTop() == 2 && !isEndOfStory()){
            storyText.setText(getStoryID(3, 1));
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
            setEndOfStory(true);
        } else if (getCounterBottom() == 1 && !isEndOfStory()) {
            storyText.setText(getStoryID(1, 0));
            buttonTop.setText(getStoryID(1, 1));
            buttonBottom.setText(getStoryID(1, 2));
            setStep(getStep() + 1);
            setEndOfStory(false);
        } else if (getCounterBottom() == 2 && !isEndOfStory() ){
            storyText.setText(getStoryID(3, 0));
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
            setEndOfStory(true);
        } else if (getCounterBottom() == 3 && !isEndOfStory()) {
            storyText.setText(getStoryID(2, 0));
            buttonTop.setText(getStoryID(2, 1));
            buttonBottom.setText(getStoryID(2, 2));
            setEndOfStory(false);
        } else {

        }
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getStoryID(int index1, int index2) {
        return story[index1].getStoryID(index1, index2);
    }

    public boolean isEndOfStory() {
        return endOfStory;
    }

    public void setEndOfStory(boolean endOfStory) {
        this.endOfStory = endOfStory;
    }

    public int getCounterTop() {
        return counterTop;
    }

    public void setCounterTop(int counterTop) {
        this.counterTop = counterTop;
    }

    public int getCounterBottom() {
        return counterBottom;
    }

    public void setCounterBottom(int counterBottom) {
        this.counterBottom = counterBottom;
    }
}
