package CG.washer.controller;

import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableEurekaClient
@RestController
@RequestMapping("/washers")
public class WasherController {
    @Autowired
    WasherRepository wr;

    //To find all users
    @GetMapping("/findall")
    public List<WasherDetails> findallWashers(){
        return wr.findAll();
    }
    //To find one washer with ID
    @GetMapping("/findone/{id}")
    public WasherDetails findoneWasher(@PathVariable int id){
        return wr.findById(id).get();
    }
    //To add a new Washer
    @PostMapping("/addWasher")
    public WasherDetails addWasher(@RequestBody WasherDetails washerDetails) {
        return wr.save(washerDetails);
    }
    //To delete a washer
    @DeleteMapping
    public String deleteWasher(@PathVariable int id){
        wr.deleteById(id);
        return "Washer Deleted Successfully";
    }
    //To update a washer
    public WasherDetails updateWasher(@RequestBody WasherDetails washerDetails){
        WasherDetails existingWasher = wr.findById(washerDetails.getId()).orElse(null);
        existingWasher.setLocation(washerDetails.getLocation());
        existingWasher.setName(washerDetails.getName());
        existingWasher.setPassword(washerDetails.getPassword());
        return existingWasher;
    }



}
