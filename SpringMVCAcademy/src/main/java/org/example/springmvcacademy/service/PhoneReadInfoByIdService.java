package org.example.springmvcacademy.service;


import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.dto.response.PhoneReadInfoResponseDTO;
import org.example.springmvcacademy.entity.Phone;
import org.example.springmvcacademy.exception.PhoneNotFoundException;
import org.example.springmvcacademy.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneReadInfoByIdService {
    private final PhoneRepository phoneRepository;

    public PhoneReadInfoResponseDTO findById(String id) {
        Phone phone = phoneRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(PhoneNotFoundException::new);

        return PhoneReadInfoResponseDTO.builder()
                .id(phone.getId())
                .brand(phone.getBrand())
                .name(phone.getName())
                .price(phone.getPrice())
                .build();
    }
}
