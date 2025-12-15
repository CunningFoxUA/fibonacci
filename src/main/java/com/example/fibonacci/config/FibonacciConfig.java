package com.example.fibonacci.config;

import com.example.fibonacci.dto.StudentName;
import com.example.fibonacci.service.FibonacciService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class FibonacciConfig {
    @Bean
    public Map<StudentName, FibonacciService> strategies(final List<FibonacciService> services) {
        return services.stream()
                .collect(Collectors.toMap(
                        FibonacciService::getStudentName,
                        Function.identity()));
    }
}