# In-Memory-Key-Value-Store-LLD
In-Memory Key-Value Store like Redis.

# Requirements
* The key-value store will be in-memory and does not require access to the file system.
* The key will always be a string.
* The value would be an object/map. The object would have attributes and corresponding values. <br>
  Example => "sde_bootcamp": { "title": "SDE-Bootcamp", "price": 30000.00, "enrolled": false, "estimated_time": 30 }
* Each attribute key would be a string and the attribute values could be string, integer, double or boolean.
* The key-value store should be thread-safe.
* The Key-Value store should expose the following functions:
  <br> get(String key) => Should return the value (object with attributes and their values). Return null if key not present
  <br> search(String attributeKey, String attributeValue) => Returns a list of keys that have the given attribute key, value pair.
  <br> put(String key, List<Pair<String, String>> listOfAttributePairs) => Adds the key and the attributes to the key-value store. If the key already exists then the value is replaced.
  <br> delete(String key) => Deletes the key, value pair from the store.
  <br> keys() => Return a list of all the keys
* The value object should override the toString method to print the object as a comma-separated list of key-value pairs for the attributes.
  <br> Example: attribute1: attribute_value_1, attribute2: attribute_value_2, attribute3: attribute_value_3
* The data type of an attribute should get fixed after its first occurrence. 
  <br> Example: Once we encounter an attribute age with an integer value then any entry with an age attribute having a non-integer value should result in an exception.
* Nothing should be printed inside any of these methods. All scanning and printing should happen in the Driver/Main class only. Exception Handling should also happen in the Driver/Main class.

# Input Format
Multiple lines with each line containing a command.<br>

Possible commands:<br>

<br>`get <key>`
<br>`put <key> <attributeKey1> <attributeValue1> <attributeKey2> <attributeValue2>....`
<br>`delete <key>`
<br>`search <attributeKey> <attributeValue>`
<br>`keys`
<br>`exit`
<br><br>Stop taking the input when you encounter the word exit.

<br>Assume that attribute keys and values would not have space in between.

#Output Format
Print output based on the specific commands as mentioned below.

* get
  <br> Comma and space-separated attributes. Example:
  <br> `attribute1: attribute_value_1, attribute2: attribute_value_2, attribute3: attribute_value_3`
  <br> Print "No entry found for <key>" if get returns null.

* put
<br>Do not print anything. Print "Data Type Error" if attribute has data type other than previous set.

* delete
<br>Do not print anything.

* search
<br>Comma-separated keys. Example:
<br>`key1,key2,key3,key4`

* keys
<br>Comma-separated keys. Example:
<br>`key1,key2,key3,key4`
<br>Print in sorted order

# Example
## Sample Input
```
put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled false estimated_time 30
get sde_bootcamp
keys
put sde_kickstart title SDE-Kickstart price 4000 enrolled true estimated_time 8
get sde_kickstart
keys
put sde_kickstart title SDE-Kickstart price 4000.00 enrolled true estimated_time 8
get sde_kickstart
keys
delete sde_bootcamp
get sde_bootcamp
keys
put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled true estimated_time 30
search price 30000.00
search enrolled true
```

##Expected Output
```
title: SDE-Bootcamp, price: 30000.00, enrolled: false, estimated_time: 30
sde_bootcamp
Data Type Error
No entry found for sde_kickstart
sde_bootcamp
title: SDE-Kickstart, price: 4000.00, enrolled: true, estimated_time: 8
sde_bootcamp,sde_kickstart
No entry found for sde_bootcamp
sde_kickstart
sde_bootcamp
sde_bootcamp,sde_kickstart

```
