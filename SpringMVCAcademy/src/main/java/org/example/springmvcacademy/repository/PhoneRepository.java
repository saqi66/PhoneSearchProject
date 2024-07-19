package org.example.springmvcacademy.repository;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.example.springmvcacademy.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {
    Optional<Phone> findByIdAndStatus(String s, String status);

    List<Phone> findAllByStatus(String status);

    Optional<Phone> findById(String id);
}
