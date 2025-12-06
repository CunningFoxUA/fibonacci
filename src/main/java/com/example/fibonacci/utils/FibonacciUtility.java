package com.example.fibonacci.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FibonacciUtility {

    public static List<BigInteger> calculateStep(final int steps) {
        var list = Stream.of(BigInteger.ZERO, BigInteger.ONE).toList();
        if (steps <= 0) return list;

        var size = list.size();
        var next = list.get(size - 1).add(list.get(size - 2));

        List<BigInteger> copy = new ArrayList<>(list);
        copy.add(next);

        return calculateStep(steps - 1, copy);
    }

    public static List<BigInteger> calculateLimit(final double limit) {
        var list = Stream.of(BigInteger.ZERO, BigInteger.ONE).toList();
        var size = list.size();

        var next = list.get(size - 1).add(list.get(size - 2));
        if (limit <= next.doubleValue()) return list;

        List<BigInteger> copy = new ArrayList<>(list);
        copy.add(next);

        return calculateLimit(limit, copy);
    }

    private static List<BigInteger> calculateStep(final int steps,
                                                  final List<BigInteger> list) {
        if (steps <= 0) return list;

        var size = list.size();
        var next = list.get(size - 1).add(list.get(size - 2));

        List<BigInteger> copy = new ArrayList<>(list);
        copy.add(next);

        return calculateStep(steps - 1, copy);
    }

    private static List<BigInteger> calculateLimit(final double limit,
                                                   final List<BigInteger> list) {
        var size = list.size();

        var next = list.get(size - 1).add(list.get(size - 2));
        if (limit <= next.doubleValue()) return list;

        List<BigInteger> copy = new ArrayList<>(list);
        copy.add(next);

        return calculateLimit(limit, copy);
    }
}
