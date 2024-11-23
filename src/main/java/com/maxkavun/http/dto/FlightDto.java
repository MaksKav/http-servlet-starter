package com.maxkavun.http.dto;

import java.util.Objects;

// DTO служить только для того что бы передавать данные из одного слоя на другой
public class FlightDto {

    private final Long ID;
    private final String DESCRIPTION;


    public FlightDto(Long id, String description) {
        this.ID = id;
        this.DESCRIPTION = description;
    }

    public Long getId() {
        return ID;
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
               "id=" + ID +
               ", DESCRIPTION='" + DESCRIPTION + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(ID, flightDto.ID) && Objects.equals(DESCRIPTION, flightDto.DESCRIPTION);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, DESCRIPTION);
    }
}
