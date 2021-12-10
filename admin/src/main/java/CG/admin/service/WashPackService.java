package CG.admin.service;

import CG.admin.exceptionHandlers.API_requestException;
import CG.admin.model.WashPacks;
import CG.admin.repository.WashPackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WashPackService {

    @Autowired
    private WashPackRepo wr;

    //To add a WashPack
    public WashPacks addWashPack(WashPacks washPacks){
        return wr.save(washPacks);
    }
    //To find all washpacks
    public List<WashPacks> findallWP(){
        return wr.findAll();
    }
    //To find one WashPack
    public WashPacks findoneWP(int id){
        return wr.findById(id).get();
    }
    //To delete a WashPack
    public String deleteWashPack(int id){
        boolean doesWPexists=wr.existsById(id);
        if(doesWPexists){
            wr.deleteById(id);
            return "Wash Pack with "+id+" deleted Successfully";
        }
        else {
            throw new API_requestException("WashPack not found, deletion failed");
        }
    }
    //To update a WashPack
    public WashPacks updateWP(WashPacks washPacks){
        WashPacks existingWashPack=wr.findById(washPacks.getId()).orElse(null);
        existingWashPack.setCost(washPacks.getCost());
        existingWashPack.setName(washPacks.getName());
        existingWashPack.setDescription(washPacks.getDescription());
        return wr.save(existingWashPack);
    }
}
