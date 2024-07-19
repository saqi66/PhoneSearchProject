package org.example.springmvcacademy.service;

import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.dto.request.PhoneUpdateRequestDTO;
import org.example.springmvcacademy.entity.Phone;
import org.example.springmvcacademy.exception.PhoneNotFoundException;
import org.example.springmvcacademy.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneUpdateService {
    private final PhoneRepository repository;

    public void update(String id, PhoneUpdateRequestDTO updateRequestDTO) {
        Phone phone = repository.findByIdAndStatus(id, "A")
                .stream()
                .findFirst().
                orElseThrow(PhoneNotFoundException::new);

        phone.setBrand(updateRequestDTO.getBrand());
        phone.setName(updateRequestDTO.getName());
        phone.setMemory(updateRequestDTO.getMemory());
        phone.setColor(updateRequestDTO.getColor ());
        phone.setPrice(updateRequestDTO.getPrice());

        repository.save(phone);
    }
}