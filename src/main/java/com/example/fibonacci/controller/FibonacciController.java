package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class FibonacciController {
    //хочу побачити ваші ідеї
    // Я хочу надіслати запит example: http://localhost:9090/math/ROMAN/fibonacci?input=19&type=step
    // і хочу побачити що викликається саме метод який написав Роман ,
    // це метод саме який рахує по кроках ну і інпет для нього 19
    @GetMapping("/{student}/fibonacci")
    public ResponseEntity<String> fibonacci(
            @PathVariable StudentName student,
            @RequestParam FibonacciType type,
            @RequestParam Double input) {
        //write your code here;

        return ResponseEntity.ok("Fibonacci");
    }
}
