package org.example.springmvcacademy.service;

import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.entity.Phone;
import org.example.springmvcacademy.exception.PhoneNotFoundException;
import org.example.springmvcacademy.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneDeleteService {
    private final PhoneRepository phoneRepository;

    public void deleteById(String id) {
        Phone phone = phoneRepository.findByIdAndStatus(id, "D")
                .stream()
                .findFirst()
                .orElseThrow(PhoneNotFoundException::new);
        phone.setStatus("D");
        phoneRepository.save(phone);
    }
}
