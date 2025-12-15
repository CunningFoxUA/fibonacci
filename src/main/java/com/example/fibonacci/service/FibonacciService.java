package com.example.fibonacci.service;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;

public interface FibonacciService {
    StudentName getStudentName();
    String calculate(final FibonacciType type, final Double input);
}