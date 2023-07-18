package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            return list.stream().allMatch(str -> Character.isUpperCase(str.charAt(0)));
        };

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            list.addAll( list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()) );
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(v -> Character.isUpperCase(v.charAt(0)) && v.endsWith(".") && v.split(" ").length > 3  ).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            return list.stream().collect(Collectors.toMap(value -> value, String::length));
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (listA, listB) -> {
            List<Integer> listC = new ArrayList<>(listA);
            listC.addAll(listB);
            return listC;
        };
    }
}
