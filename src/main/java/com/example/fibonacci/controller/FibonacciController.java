package com.example.fibonacci.controller;

import com.example.fibonacci.dto.FibonacciType;
import com.example.fibonacci.dto.StudentName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.*; // Map

@RestController
@RequestMapping("/math")
public class FibonacciController {
    //хочу побачити ваші ідеї
    // Я хочу надіслати запит example: http://localhost:9090/math/ROMAN/fibonacci?input=19&type=step
    // і хочу побачити що викликається саме метод який написав Роман ,
    // це метод саме який рахує по кроках ну і інпет для нього 19
    @GetMapping("/{student}/fibonacci")
    public ResponseEntity<Map<String, BigInteger>> fibonacci(
            @PathVariable StudentName student,
            @RequestParam FibonacciType type,
            @RequestParam Double input) {
        //write your code here;
        if ((student == StudentName.OLEKSANDR) &&
                (type == FibonacciType.STEP || type == FibonacciType.LIMIT))
        {
            return fibonacci(type, input);
        }

        return null;
    }

    private ResponseEntity<Map<String, BigInteger>> fibonacci(FibonacciType type, Double input)
    {
        ArrayList<BigInteger> fibonacciArray = new ArrayList<>();

        if (input <= 0.0) {
            fibonacciArray.add(BigInteger.ZERO);
            Map<String, BigInteger> fibonacciResponse = fibonacciJson(fibonacciArray);
            return ResponseEntity.ok(fibonacciResponse);}

        if (input == 1.0 || input == 2.0) {
            fibonacciArray.add(BigInteger.ONE);
            Map<String, BigInteger> fibonacciResponse = fibonacciJson(fibonacciArray);
            return ResponseEntity.ok(fibonacciResponse);}

        fibonacciArray.add(BigInteger.ZERO);
        fibonacciArray.add(BigInteger.ONE);

        fibonacciRecursion(fibonacciArray, type, input);

        Map<String, BigInteger> fibonacciResponse = fibonacciJson(fibonacciArray);

        return ResponseEntity.ok(fibonacciResponse);
    }

    private void fibonacciRecursion(ArrayList<BigInteger> array, FibonacciType type, Double input)
    {
        if (type == FibonacciType.STEP && input <= 0) return;

        BigInteger next = array.get(array.size() - 2).add(array.getLast());
        if (type == FibonacciType.LIMIT && input <= next.intValue()) return;

        array.add(next);

        if (type == FibonacciType.STEP) fibonacciRecursion(array, type, input - 1);
        if  (type == FibonacciType.LIMIT) fibonacciRecursion(array, type, input);

    }

    private Map<String, BigInteger> fibonacciJson(ArrayList<BigInteger> array)
    {
        Map<String, BigInteger> response = new LinkedHashMap<>();
        for (int i = 0; i <= array.size() - 1; i++)
        {
            response.put("step[" + i + "]",  array.get(i));
        }
        return response;
    }

}
