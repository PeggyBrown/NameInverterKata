package com.st.kata.nameinverter;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NameInverter {

    public String invert(String name) {
        if (StringHelper.isEmptyOrSpaces(name)) {
            return "";
        }
        ArrayList<String> splitName = splitName(name);
        return StringHelper.createInvertedString(splitName);
    }

    private ArrayList<String> splitName(String name) {
        return new ArrayList<>(List.of(name.split(" ")));
    }
}

class StringHelper {

    public static String createInvertedString(ArrayList<String> splitName) {
        splitName.removeIf(n -> List.of("Pan", "Pani").contains(n));
        return String.join(", ", revertList(splitName));
    }

    private static ArrayList<String> revertList(ArrayList<String> splitName) {
        return Lists.newArrayList(new LinkedList<>(splitName)
                .descendingIterator());
    }

    public static boolean isEmptyOrSpaces(String name) {
        return name.trim().isEmpty();
    }

}
