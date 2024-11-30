package ru.mpei.romanov.databases.web_client_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mpei.romanov.databases.web_client_app.entity.event.Event;
import ru.mpei.romanov.databases.web_client_app.dto.request.EventRequestDto;
import ru.mpei.romanov.databases.web_client_app.service.entity.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/event")
public class EventRestController {

    private final EventService eventService;

    @GetMapping
    public Event getEventById(@RequestParam("id") Long id) {
        return eventService.findEventById(id);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.findAllEvents();
    }

    @PostMapping
    public ResponseEntity<EventRequestDto> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        eventService.saveEvent(eventRequestDto);
        return ResponseEntity.ok(eventRequestDto);
    }

    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestParam("id") Long id, @RequestBody Event event) {
        eventService.updateEvent(id, event);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEvent(@RequestParam("id") Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build();
    }
}
