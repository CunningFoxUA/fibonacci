package com.example.fibonacci.controller;
import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import com.example.fibonacci.service.FibonacciService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/math")
public class FibonacciController {
    private final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    // Я хочу надіслати запит example: http://localhost:9090/math/ROMAN/fibonacci?input=19&type=step
    @GetMapping("/{student}/fibonacci")
    public ResponseEntity<String> fibonacci(
            @PathVariable StudentName student,
            @RequestParam FibonacciType type,
            @RequestParam Double input) {

        switch (student) {
            case OLEKSANDR:
                List<BigInteger> fibArray = new ArrayList<>();
                fibArray.add(BigInteger.ZERO);
                fibArray.add(BigInteger.ONE);
                var response = switch (type) {
                    case STEP -> fibonacciService.oleksandrRecursionStep(fibArray, input);
                    case LIMIT -> fibonacciService.oleksandrRecursionLimit(fibArray, input);
                };
                return ResponseEntity.ok(response.toString());

            case ROMAN: break;
            case NADIA: break;
            case POLINA: break;
            case STEPAN: break;
            default: break;


        }
        return null;
    }
}
