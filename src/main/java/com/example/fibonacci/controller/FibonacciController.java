package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/math")
public class FibonacciController {
    @GetMapping("/{student}/fibonacci")
    public ResponseEntity<String> fibonacci(
            @PathVariable StudentName student,
            @RequestParam FibonacciType type,
            @RequestParam Integer input) {

        if (student == StudentName.POLINA) {
            return ResponseEntity.ok(generateFibonacci(input, type));
        }
        return ResponseEntity.ok("");
    }
    private String generateFibonacci(int input, FibonacciType type) {
        List<Integer> sequence = new ArrayList<>();
        int i = 0;
        int value;

        if (type == FibonacciType.STEP) {
            while (i <= input) {
                sequence.add(fib(i));
                i++;
            }
        } else if (type == FibonacciType.LIMIT) {
            while ((value = fib(i)) <= input) {
                sequence.add(value);
                i++;
            }
        }
        return sequence.toString();
    }
    private int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
