/*
Given an array of strings strs, group the anagrams together.

Two strings are anagrams if they contain the same characters in a different order.

Example
Input: ["eat","tea","tan","ate","nat","bat"]

Output:
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]
  */

import java.util.*;
public class GroupAnagrams{

public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {

        // convert string to char array
        char[] chars = s.toCharArray();

        // sort characters
        Arrays.sort(chars);

        // create key
        String key = new String(chars);

        // create list if key doesn't exist
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }

    // return grouped anagrams
    return new ArrayList<>(map.values());
}
}
