package com.example.fibonacci.service;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class YaroslavFibonacciService implements FibonacciService {

    @Override
    public StudentName getStudentName() {
        return StudentName.YAROSLAV;
    }

    @Override
    public String calculate(final FibonacciType type,
                            final Double input) {
        var result = switch (type) {
            case STEP -> calculateStep(input.intValue(),
                    //.toList() -> Unmodif.
                    //.collect(Collectors.toList()) -> modif.
                    Stream.of(BigInteger.ZERO, BigInteger.ONE).collect(Collectors.toList()));
            case LIMIT -> calculateLimit(input.intValue(),
                    Stream.of(BigInteger.ZERO, BigInteger.ONE).collect(Collectors.toList()));
        };
        return result.toString();
    }

    private List<BigInteger> calculateStep(final int steps,
                                           final List<BigInteger> list) {
        if (steps <= 0 ) return list;

        var size = list.size();
        var next = list.get(size - 1).add(list.get(size - 2));

        list.add(next);

        return calculateStep(steps - 1, list);
    }

    private List<BigInteger> calculateLimit(final double limit,
                                            final List<BigInteger> list) {
        var size = list.size();

        var next = list.get(size - 1).add(list.get(size - 2));
        if (limit <= next.doubleValue()) return list;

        list.add(next);

        return calculateLimit(limit, list);
    }
}