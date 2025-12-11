package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import com.example.fibonacci.service.FibonacciService;
import com.example.fibonacci.service.FibonacciStrategyResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class FibonacciController {

    private final FibonacciStrategyResolver resolver;

    public FibonacciController(FibonacciStrategyResolver resolver) {
        this.resolver = resolver;
    }

    @GetMapping("/{student}/fibonacci")
    public ResponseEntity<String> fibonacci(
            @PathVariable StudentName student,
            @RequestParam FibonacciType type,
            @RequestParam Double input) {
        FibonacciService service = resolver.getService(student);

        if (service == null) {
            return ResponseEntity.badRequest()
                    .body("Unsupported student: " + student);
        }

        return ResponseEntity.ok(service.calculate(type, input));
    }
}
