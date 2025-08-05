package com.example.ecommercebackend.utils.country;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable UUID id) {

        return ResponseEntity.ok(countryService.getCountryById(id));
    }
}
