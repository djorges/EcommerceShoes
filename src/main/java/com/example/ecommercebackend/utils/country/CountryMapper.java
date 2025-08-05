package com.example.ecommercebackend.utils.country;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toEntity(CountryDto countryDto);

    @Mapping(target = "continent", source = "location.continent")
    CountryDto toDto(Country country);

    //Language Mapper
    @Mapping(target= "isOfficialLanguage", source = "isOfficial")
    @Mapping(target = "speakersTotal", source = "speakersCount")
    LanguageDto toDto(Language language);
}
