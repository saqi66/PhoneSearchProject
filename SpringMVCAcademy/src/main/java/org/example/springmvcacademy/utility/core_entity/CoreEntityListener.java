package org.example.springmvcacademy.utility.core_entity;


import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.example.springmvcacademy.utility.QDate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoreEntityListener {
    @PrePersist
    private void preInsert(CoreEntity entity) {
        entity.setStatus("A");
        entity.setInsertDate(QDate.getDateTimeLong());
        entity.setCreatedDate(QDate.getCurrentDateLong());
        entity.setCreatedTime(QDate.getCurrentTimeLong());
    }

    @PreUpdate
    private void preUpdate(CoreEntity entity) {
        entity.setModificationDate(QDate.getCurrentDateLong());
        entity.setModificationTime(QDate.getCurrentTimeLong());
    }
}
