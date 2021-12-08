package CG.washer.service;

import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WasherService {

    @Autowired
    WasherRepository wr;

    //To find all users
    public List<WasherDetails> findallWashers(){
        return wr.findAll();
    }
    //To find one washer with ID
    public WasherDetails findoneWasher(int id){
        return wr.findById(id).get();
    }
    //To add a new Washer
    public WasherDetails addWasher(WasherDetails washerDetails) {
        return wr.save(washerDetails);
    }
    //To delete a washer
    public String deleteWasher(int id){
        wr.deleteById(id);
        return "Washer Deleted Successfully";
    }
    //To update a washer
    public WasherDetails updateWasher(WasherDetails washerDetails){
        WasherDetails existingWasher = wr.findById(washerDetails.getId()).orElse(null);
        existingWasher.setName(washerDetails.getName());
        existingWasher.setPassword(washerDetails.getPassword());
        return wr.save(existingWasher);
    }
}
