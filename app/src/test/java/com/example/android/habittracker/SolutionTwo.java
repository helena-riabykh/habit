package com.example.android.habittracker;

import java.util.HashMap;

/**
 * Created by Anton on 16.09.2020.
 */
public class SolutionTwo {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('(', ')');
        hm.put('{', '}');
        hm.put('[', ']');

        boolean valid = true;

        //      while (valid) {
        //       if (hm.containsKey(s.charAt(i))) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (hm.containsKey(s.charAt(i))) {
                    if (s.charAt(s.length() - 1 -i) == hm.get(s.charAt(i))) {
                        valid = true;
                    }else if (s.charAt(i + 1) == hm.get(s.charAt(i))){
                        valid = true;
                    } else {
                        valid = false;
                        break;
                    }
                }
            }

            System.out.println(valid);
            return valid;
        }
    }

