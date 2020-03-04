package com.example.jjwt568;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
public class TokenController {

    @GetMapping
    public String token() {
        return CompletableFuture.supplyAsync(tokenSupplier()).join();
    }

    private static Supplier<String> tokenSupplier() {
        return () -> Jwts.builder()
                .setClaims(Map.of(Claims.SUBJECT, "subject"))
                .compact();
    }
}
