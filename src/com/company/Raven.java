package com.company;

import java.util.Scanner;

public class Raven {
    private String [] positive = {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
    private String [] negative = {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid"};
    private String answer="";
    private int posCounter, negCounter;
    private ChatHistory chatHistory = new ChatHistory();

    public Raven(){}
    //All the input and output will happen in this method
    public void  runRaven(){
        Scanner input = new Scanner(System.in);
        System.out.println("Good morning, how are you feeling today?(q - quit) ");
        while(!answer.equalsIgnoreCase("q")){
            answer = input.nextLine();
            chatHistory.addHistory("User: "+answer);
            if(!answer.equalsIgnoreCase("q")){
                checkWordCount(answer);//this will check for number of positive and negative words
                if(posCounter>negCounter){
                    if(posCounter > 3){
                        System.out.println(getMehResponse());
                    }else{
                        System.out.println(getPostiveResponse());
                    }
                }else if(posCounter == negCounter){
                    System.out.println(getMehResponse());
                }else if(posCounter<negCounter){
                    if(negCounter>3){
                        System.out.println(getPostiveResponse());
                    }else{
                        System.out.println(getNegativeResponse());
                    }
                }
            }
        }
        chatHistory.getHistory();
    }


    public void checkWordCount(String answer){
        //this would check through every word in the answer provided by the user
        //and compare it to the arrays of positive or negative
        String[] strArr = answer.split(" ");
        for(String word: strArr) {
            for (String posWord : positive) {
                if (word.equalsIgnoreCase(posWord)) {
                    posCounter++;
                }
            }
            for (String negWord : negative) {
                if (word.equalsIgnoreCase(negWord)) {
                    negCounter++;
                }
            }
        }
    }

    private String getPostiveResponse() {
        int randOption = (int)(1+Math.random()*4);
        String rStr="";
        switch (randOption){
            case 1:
                rStr = "Great to hear!";
                break;
            case 2:
                rStr = "I am so happy for you!";
                break;
            case 3:
                rStr = "That's great! What do you feel like doing today?";
                break;
            case 4:
                rStr = "What are you doing today?";
                break;
        }
        chatHistory.addHistory("Raven: "+rStr);
        return rStr;
    }

    private String getMehResponse() {
        int randOption = (int)(1+Math.random()*6);
        String rStr="";
        switch (randOption){
            case 1:
                rStr = "Ok";
                break;
            case 2:
                rStr = "Meh";
                break;
            case 3:
                rStr = "Do you want a cookie?";
                break;
            case 4:
                rStr = "Are we done here?";
                break;
            case 5:
                rStr = "Alright, I'm going to sleep.";
                break;
            case 6:
                rStr = "[Puts headphones on]";
                break;
        }
        chatHistory.addHistory("Raven: "+rStr);
        return rStr;
    }

    private String getNegativeResponse() {
        int randOption = (int)(1+Math.random()*3);
        String rStr="";
        switch (randOption){
            case 1:
                rStr = "Why do you say that?";
                break;
            case 2:
                rStr = "Really! Why, tell me more?";
                break;
            case 3:
                rStr = "I'm sorry to hear that";
                break;
        }
        chatHistory.addHistory("Raven: "+rStr);
        return rStr;
    }

}
