package CG.user.service;

import CG.user.Repository.CarRepo;
import CG.user.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class carService {

    @Autowired
    private CarRepo cr;

    //To find all the cars
    public List<Car> allCars(){
        return cr.findAll();
    }
    //To find one car by id
    public Car findoneCar(int id){
        return cr.findById(id).get();
    }
    //To add a car
    public Car addCar(Car car){
        return cr.save(car);
    }
    //To delete car by id
    public String deleteCar(int id){
        cr.deleteById(id);
        return "Car with ID "+id+" deleted successfully";
    }
    //To update the name of the car
    public Car updateCar(Car car){
        Car existingCar= cr.findById(car.getId()).orElse(null);
        existingCar.setName(car.getName());
        return cr.save(existingCar);
    }

}
