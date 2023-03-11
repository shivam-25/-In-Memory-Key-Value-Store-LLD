package com.shivam.keyvaluestore.service;

import com.shivam.keyvaluestore.utils.AttributeType;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StoreFunctions implements IStoreFunctions{

    Map<String, Object> keyValueMap;

    Map<String, Class> typeMap;

    public StoreFunctions() {
        this.keyValueMap = new ConcurrentHashMap<>();
        this.typeMap = new HashMap<>();
    }

    @Override
    public String get(String key) {
        Map<String, Object> attributeMap = (Map<String, Object>) keyValueMap.get(key);
        if(attributeMap==null) {
            return "No entry found for "+key;
        } else {
            List<String> attributes = new ArrayList<>();
            for(Map.Entry<String, Object> e: attributeMap.entrySet()) {
                attributes.add(e.getKey()+": "+ e.getValue());
            }
            return String.join(", ", attributes);
        }
    }

    @Override
    public String search(String attributeKey, String attributeValue) {
        List<String> keys = new ArrayList<>();
        for(Map.Entry<String, Object> e: keyValueMap.entrySet()) {
            String key = e.getKey();
            Map<String, Object> attributeMap = (Map<String, Object>) e.getValue();
            if(attributeMap.containsKey(attributeKey) && attributeMap.get(attributeKey).toString().equals(attributeValue)) {
                keys.add(key);
            }
        }
        Collections.sort(keys);
        return String.join(",", keys);
    }

    @Override
    public void put(String key, List<Pair<String, String>> listOfAttributePairs) {
        AttributeType attributeTypeUtil = new AttributeType();
        Map<String, Object> attributeMap = new HashMap<>();
            for(Pair<String, String> pair: listOfAttributePairs) {
                if(typeMap.containsKey(pair.getKey())) {
                    if(!attributeTypeUtil.getAttributeType(pair.getValue()).equals(typeMap.get(pair.getKey()))) {
                        System.out.println("Data Type Error");
                        return;
                    }
                } else {
                    typeMap.put(pair.getKey(), attributeTypeUtil.getAttributeType(pair.getValue()));
                }
                attributeMap.put(pair.getKey(), pair.getValue());
            }
            keyValueMap.put(key, attributeMap);
    }

    @Override
    public void delete(String key) {
        keyValueMap.remove(key);
    }

    @Override
    public String keys() {
        List<String> keys = new ArrayList<>(keyValueMap.keySet());
        Collections.sort(keys);
        return String.join(",", keys);
    }

}
