package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (student == StudentName.ROMAN) return RomanFib(input.intValue(), type);

        return ResponseEntity.ok("Fibonacci");
    }

    private ResponseEntity<String> RomanFib(int input, FibonacciType type){
        List<BigInteger> nums = new ArrayList<>();
        nums.add(BigInteger.ZERO); nums.add(BigInteger.ONE);

        RomanRecursion(input, nums, type);

        return ResponseEntity.ok(nums.toString());
    }

    private void RomanRecursion(int input, List<BigInteger> nums, FibonacciType type){
        if (type == FibonacciType.STEP && input <= 0) return;

        BigInteger last = nums.getLast();
        if (type == FibonacciType.LIMIT && input <= last.intValue()) return;

        BigInteger previous = nums.get(nums.size() - 2);

        BigInteger next = last.add(previous);
        nums.add(next);

        if (type == FibonacciType.STEP)  RomanRecursion(input - 1, nums, type);
        if (type == FibonacciType.LIMIT) RomanRecursion(input, nums, type);
    }
}
