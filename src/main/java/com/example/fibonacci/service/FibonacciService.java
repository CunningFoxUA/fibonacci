package com.example.fibonacci.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FibonacciService {

    public List<BigInteger> oleksandrRecursionStep(final List<BigInteger> array, final Double steps) {
        if (steps <= 0) return array;

        var next = array.get(array.size() - 2).add(array.getLast());
        array.add(next);

        return oleksandrRecursionStep(array, steps - 1);
    }

    public List<BigInteger> oleksandrRecursionLimit(final List<BigInteger> array, final Double limit) {
        var next = array.get(array.size() - 2).add(array.getLast());
        if (limit <= next.doubleValue()) return array;

        array.add(next);

        return oleksandrRecursionLimit(array, limit);
    }
}
