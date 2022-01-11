package CG.admin.service;

import CG.admin.exceptionHandlers.API_requestException;
import CG.admin.model.WashPacks;
import CG.admin.repository.WashPackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WashPackService {

    @Autowired
    private WashPackRepo wr;

    //To add a WashPack
    public WashPacks addWP(WashPacks washPacks){
        return wr.save(washPacks);
    }
    //To find all washpacks
    public List<WashPacks> findallWP(){
        return wr.findAll();
    }
    //To find one WashPack
    public WashPacks findoneWP(String id){
        return wr.findById(id).get();
    }
    //To delete a WashPack
    public ResponseEntity<Map<String,Boolean>> deleteWP(String id){
        WashPacks wp=wr.findById(id).orElseThrow(() ->  new API_requestException("Washpack with ID -> "+id+"deletion failed"));
        wr.delete(wp);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Washpack Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    //To update a WashPack
    public WashPacks updateWP(WashPacks washPacks){
        boolean doesWPexists=wr.existsById(washPacks.getId());
        if(doesWPexists){
            WashPacks existingWashPack=wr.findById(washPacks.getId()).orElse(null);
            existingWashPack.setCost(washPacks.getCost());
            existingWashPack.setName(washPacks.getName());
            existingWashPack.setDescription(washPacks.getDescription());
            return wr.save(existingWashPack);
        }
        else {
            throw new API_requestException("WashPack not found in database, update request failed");
        }
    }
}
