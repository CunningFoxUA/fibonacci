package com.example.fibonacci.utils;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciUtil {
    private FibonacciUtil() {};

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