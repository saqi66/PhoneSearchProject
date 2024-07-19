package org.example.springmvcacademy.service;

import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.dto.response.PhoneReadInfoResponseDTO;
import org.example.springmvcacademy.entity.Phone;
import org.example.springmvcacademy.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneReadInfoService {
    private final PhoneRepository phoneRepository;

    public List<PhoneReadInfoResponseDTO> readInfo() {
        List<Phone> phones = phoneRepository.findAllByStatus("A");
        return phones.stream()
                .map(phone -> PhoneReadInfoResponseDTO.builder()
                        .id(phone.getId())
                        .name(phone.getName())
                        .memory(phone.getMemory())
                        .color(phone.getColor())
                        .build())
                .toList();
    }
}
