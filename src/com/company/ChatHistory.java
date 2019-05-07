package com.company;

import java.util.ArrayList;

public class ChatHistory {
    ArrayList<String> history = new ArrayList<>();

    public void getHistory() {
        for(String str: history){
            System.out.printf(str+"\n");
        }
    }

    public void addHistory(String history) {
        this.history.add(history);
    }
}
