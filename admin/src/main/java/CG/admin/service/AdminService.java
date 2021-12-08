package CG.admin.service;

import CG.admin.model.AdminDetails;
import CG.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo ar;

    //To get all admins
    public List<AdminDetails> findallAdmins(){
        return ar.findAll();
    }
    //To find one admin
    public AdminDetails findoneAdmin(int id){
        return ar.findById(id).get();
    }
    //To add an admin
    public AdminDetails addAdmin(AdminDetails adminDetails){
        return ar.save(adminDetails);
    }
    //To delete an admin
    public String deleteAdmin(int id){
        ar.deleteById(id);
        return "Admin with ID"+id+"deleted successfully";
    }
    //To update an admin
    public AdminDetails updateAdmin(AdminDetails adminDetails){
        AdminDetails existingAdmin= ar.findById(adminDetails.getId()).orElse(null);
        existingAdmin.setName(adminDetails.getName());
        existingAdmin.setPassword(adminDetails.getPassword());
        return ar.save(existingAdmin);
    }
}
