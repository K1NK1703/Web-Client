package ru.mpei.romanov.databases.web_client_app.entity.sensor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensors")
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_id", nullable = false)
    private Long typeId;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "factory_id")
    private Long factoryId;

    @Column(name = "install_date")
    private LocalDate installDate;

    @Column(name = "editor_id")
    private Long editorId;

    @Column(name = "event_id")
    private Long eventId;
}
