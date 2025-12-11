package com.example.fibonacci.service;

import com.example.fibonacci.dto.StudentName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FibonacciStrategyResolver {

    private final Map<StudentName, FibonacciService> strategies;

    public FibonacciStrategyResolver(final List<FibonacciService> services) {
        this.strategies = services.stream()
                .collect(Collectors.toMap(
                        FibonacciService::getStudentName,
                        s -> s
                ));
    }

    public FibonacciService getService(final StudentName student) {
        return strategies.get(student);
    }
}