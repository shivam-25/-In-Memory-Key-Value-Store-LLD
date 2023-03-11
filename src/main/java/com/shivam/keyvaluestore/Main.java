package com.shivam.keyvaluestore;

import com.shivam.keyvaluestore.service.StoreFunctions;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String ar[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        StoreFunctions keyValueMap = new StoreFunctions();
        while(!input.equalsIgnoreCase("exit")) {
            String[] inputList = input.split(" ");
            switch(inputList[0]) {
                case "get":
                    System.out.println(keyValueMap.get(inputList[1]));
                    break;
                case "delete":
                    keyValueMap.delete(inputList[1]);
                    break;
                case "keys":
                    System.out.println(keyValueMap.keys());
                    break;
                case "search":
                    System.out.println(keyValueMap.search(inputList[1], inputList[2]));
                    break;
                case "put":
                    String key = inputList[1];
                    List<Pair<String, String>> listOfAttributePairs = new ArrayList<>();
                    for(int i=2;i<inputList.length;i+=2) {
                        listOfAttributePairs.add(new Pair<>(inputList[i], inputList[i+1]));
                    }
                    keyValueMap.put(key, listOfAttributePairs);
                    break;
            }
            input = reader.readLine().trim();
        }
    }
}
