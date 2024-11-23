package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mpei.romanov.databases.web_client_app.dto.response.EventResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.event.Event;
import ru.mpei.romanov.databases.web_client_app.service.dto.EventDtoService;
import ru.mpei.romanov.databases.web_client_app.service.entity.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/event")
public class EventRestController {

    private final EventService eventService;
    private final EventDtoService eventDtoService;

    @GetMapping
    public EventResponseDto getEvent(@RequestParam("id") Long id) {
        return eventDtoService.getEventDtoById(id);
    }

    @GetMapping("/events")
    public List<EventResponseDto> getAllEvents() {
        return eventDtoService.getAllEventsDto();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
        return ResponseEntity.ok(event);
    }

    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEvent(@RequestParam("id") Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build();
    }
}
