package com.example.lab53.EventController;

import com.example.lab53.ApiResponse.ApiResponse;
import com.example.lab53.Model.Event;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Successfully added event");
    }

    @GetMapping("/get")
    public ArrayList<Event> getAllEvents() {
        return events;
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("Successfully updated event");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Successfully deleted event");
    }

    @GetMapping("/getById/{id}")
    public ArrayList<Event> getEventById(@PathVariable String id) {
        ArrayList<Event> eventsById = new ArrayList<>();
        for (Event event : events) {
            if (event.getId().equals(id)) {
                eventsById.add(event);
            }
        }
        return eventsById;
    }

    @PutMapping("/changeCapacity/{index}")
    public ApiResponse changeCapacity(@PathVariable int index ,@RequestBody int capacity) {

        events.get(index).setCapacity(events.get(index).getCapacity()-capacity);

        return new ApiResponse("Successfully changed event capacity");
    }
}
