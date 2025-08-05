package com.example.ecommercebackend.utils.country;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CountryService {
    public CountryDto getCountryById(UUID countryId) {
        if(CountryDao.db.containsKey(countryId)) {
            return CountryMapper.INSTANCE.toDto(
                CountryDao.db.get(countryId)
            );
        }else{
            log.error("Country not found");
            throw new RuntimeException("Country not found");
        }
    }
}
