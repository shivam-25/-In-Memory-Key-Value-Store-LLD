package com.shivam.keyvaluestore.service;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface IStoreFunctions {

    public String get(String key);
    public String search(String attributeKey, String attributeValue);
    public void put(String key, List<Pair<String, String>> listOfAttributePairs);
    public void delete(String key);
    public String keys();
}
