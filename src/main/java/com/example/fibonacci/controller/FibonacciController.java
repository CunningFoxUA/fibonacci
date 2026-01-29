package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import com.example.fibonacci.service.FibonacciService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/math")
@AllArgsConstructor
public class FibonacciController {

    private Map<StudentName, FibonacciService> resolver;

    @GetMapping("/{student}/fibonacci")
    public ResponseEntity<String> fibonacci(
            @PathVariable StudentName student,
            @RequestParam FibonacciType type,
            @RequestParam Double input) {
        FibonacciService service = resolver.get(student);

        if (service == null) {
            return ResponseEntity.badRequest()
                    .body("Unsupported student: " + student);
        }

        return ResponseEntity.ok(service.calculate(type, input));
    }
}
