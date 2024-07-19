package org.example.springmvcacademy.service;

import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.dto.request.PhoneCreateRequestDTO;
import org.example.springmvcacademy.entity.Phone;
import org.example.springmvcacademy.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneCreateService {
    private final PhoneRepository phoneRepository;


    public void createPhone(PhoneCreateRequestDTO createRequestDTO) {
        var save = Phone.builder()
                .name(createRequestDTO.getName())
                .memory(createRequestDTO.getMemory())
                .color(createRequestDTO.getColor())
                .price(createRequestDTO.getPrice())
                .build();
        phoneRepository.save(save);
    }
}
