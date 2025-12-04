package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.fibonacci.utils.FibonacciUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
        switch (student) {
            case ROMAN :
                List<BigInteger> nums = new ArrayList<>();
                nums.add(BigInteger.ZERO); nums.add(BigInteger.ONE);

                var result = switch (type) {
                    case STEP -> FibonacciUtil.romanRecursionStep(input.intValue(), nums);
                    case LIMIT -> FibonacciUtil.romanRecursionLimit(input, nums);
                };

                return ResponseEntity.ok(result.toString());

            case NADIA: break;
            case POLINA: break;
            case OLEKSANDR: break;
            case STEPAN: break;
            default: break;
        }

        return ResponseEntity.ok("Fibonacci");
    }
}
