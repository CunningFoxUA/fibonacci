package com.example.fibonacci.service;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RomanFibonacciService implements FibonacciService {

    @Override
    public StudentName getStudentName() {
        return StudentName.ROMAN;
    }

    @Override
    public String calculate(final FibonacciType type,
                            final Double input) {
        var result = switch (type) {
            case STEP -> calculateStep(input.intValue(),
                    new ArrayList<>(List.of(BigInteger.ZERO, BigInteger.ONE)));
            case LIMIT -> calculateLimit(input.intValue(),
                    new ArrayList<>(List.of(BigInteger.ZERO, BigInteger.ONE)));
        };
        return result.toString();
    }

    private List<BigInteger> calculateStep(final int steps, final List<BigInteger> nums) {
        var sizeOfNums = nums.size();

        if (sizeOfNums < 2) throw new IllegalArgumentException("The array must contain at least 2 elements.");
        if (steps <= 0 ) return nums;

        var next = nums.get(sizeOfNums - 1).add(nums.get(sizeOfNums - 2));

        nums.add(next);

        return calculateStep(steps - 1, nums);
    }

    private List<BigInteger> calculateLimit(final double limit, final List<BigInteger> nums) {
        var sizeOfNums = nums.size();

        if (sizeOfNums < 2) throw new IllegalArgumentException("The array must contain at least 2 elements.");

        var next = nums.get(sizeOfNums - 1).add(nums.get(sizeOfNums - 2));
        if (limit <= next.doubleValue()) return nums;

        nums.add(next);

        return calculateLimit(limit, nums);
    }
}
