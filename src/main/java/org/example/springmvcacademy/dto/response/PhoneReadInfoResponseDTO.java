package org.example.springmvcacademy.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PhoneReadInfoResponseDTO {
    String id;
    String brand;
    String name;
    String memory;
    String color;
    Double price;
}
