package com.example.fibonacci.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FibonacciUtility {
    private FibonacciUtility() {};

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

    public static List<BigInteger> romanRecursionStep(final int steps, final List<BigInteger> nums) {
        var sizeOfNums = nums.size();

        if (sizeOfNums < 2) throw new IllegalArgumentException("The array must contain at least 2 elements.");
        if (steps <= 0 ) return nums;

        var next = nums.get(sizeOfNums - 1).add(nums.get(sizeOfNums - 2));

        List<BigInteger> copy = new ArrayList<>(nums);
        copy.add(next);

        return romanRecursionStep(steps - 1, copy);
    }

    public static List<BigInteger> romanRecursionLimit(final double limit, final List<BigInteger> nums) {
        var sizeOfNums = nums.size();

        if (sizeOfNums < 2) throw new IllegalArgumentException("The array must contain at least 2 elements.");

        var next = nums.get(sizeOfNums - 1).add(nums.get(sizeOfNums - 2));
        if (limit <= next.doubleValue()) return nums;

        List<BigInteger> copy = new ArrayList<>(nums);
        copy.add(next);

        return romanRecursionLimit(limit, copy);
    }
}