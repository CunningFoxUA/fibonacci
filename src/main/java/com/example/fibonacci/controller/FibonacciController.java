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
        //write your code here; викликати
        if(student == StudentName.NADIA && type == FibonacciType.STEP)
        {
            return nadyaFib(input.intValue());
        }

        return ResponseEntity.ok("Fibonacci");
    }
    // тут писати
    private ResponseEntity<String> nadyaFib(int n)
    {
        StringBuilder steps = new StringBuilder();
        long[] memo = new long[n+1];
        nadyaRec(n, steps, memo);

        steps.append("\nRESULT = ").append(memo[n]);
        return ResponseEntity.ok(steps.toString());
    }
    private void nadyaRec(int n, StringBuilder steps, long[] memo)
    {
        if(n==0)
        {
            memo[n] = n;
            steps.append("F(").append(n).append(") = ").append(n).append("\n");
            return;
        }

        if(n==1)
        {
            memo[n] = n;
            steps.append("F(").append(n).append(") = ").append(n).append("\n");
            return;
        }
        if(memo[n-1] == 0) nadyaRec(n-1, steps, memo);
        if(memo[n-2] == 0) nadyaRec(n-2, steps, memo);
        memo[n] = memo[n-1] + memo[n-2];
        steps.append("F(").append(n).append(") = ").append(memo[n]).append("\n");
    }

}
