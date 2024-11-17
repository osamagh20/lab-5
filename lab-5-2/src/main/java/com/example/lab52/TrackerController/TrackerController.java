package com.example.lab52.TrackerController;

import com.example.lab52.ApiResponse.ApiResponse;
import com.example.lab52.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {
    ArrayList<Tracker> trackers = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
        return new ApiResponse("Successfully added tracker");
    }

    @GetMapping("/get")
    public ArrayList<Tracker>  getTrackers(){
        return trackers;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTracker(@PathVariable int index,@RequestBody Tracker tracker){
        trackers.set(index, tracker);
        return new ApiResponse("Successfully updated tracker");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTracker(@PathVariable int index) {
        trackers.remove(index);
        return new ApiResponse("Successfully deleted tracker");
    }

    @GetMapping("/changeStatus")
    public ArrayList<Tracker> changeStatus(){
        for (int i = 0; i < trackers.size(); i++) {
            if(trackers.get(i).getStatus().equalsIgnoreCase("not done")) {
                trackers.get(i).setStatus("done");
            }
        }
        return trackers;
    }

    @GetMapping("/getByTitle/{title}")
    public ArrayList<Tracker> getTrackersByTitle(@PathVariable String title) {
        ArrayList<Tracker> trackersByTitle = new ArrayList<>();
        for (int i = 0; i < trackers.size(); i++) {
            if (trackers.get(i).getTitle().equalsIgnoreCase(title)) {
                trackersByTitle.add(trackers.get(i));
            }
        }
        return trackersByTitle;
    }

    @GetMapping("/getByCompanyName/{companyName}")
    public ArrayList<Tracker> getTrackersByCompanyName(@PathVariable String companyName) {
        ArrayList<Tracker> trackersByCompanyName = new ArrayList<>();
        for (int i = 0; i < trackers.size(); i++) {
            if (trackers.get(i).getCompanyName().equalsIgnoreCase(companyName)) {
                trackersByCompanyName.add(trackers.get(i));
            }
        }
        return trackersByCompanyName;
    }
}
