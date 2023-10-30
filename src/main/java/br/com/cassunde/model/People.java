package br.com.cassunde.model;

import jakarta.validation.constraints.NotNull;

public record People(@NotNull(message = "not be null") String name, String address) {}
