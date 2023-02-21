package sn.esmt.scolarite.ws;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.scolarite.dao.AppUserRepository;
import sn.esmt.scolarite.entities.AppUserEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class AppUserController {
    private AppUserRepository appUserRepository;

    //Fonction qui insere dans la Base de Donee
    @PostMapping(path = "/save")//POST REQUEST
    public AppUserEntity save(@RequestBody AppUserEntity appUserEntity){
        return appUserRepository.save(appUserEntity);
    }

    //Fonction qui retourne la liste des users
    @GetMapping(path = "/all")
    public List<AppUserEntity> getAll(){
        return appUserRepository.findAll();
    }

    //Creation et test des End-Points
    @GetMapping(path = "/login")//GET REQUEST
    public ApiLoginResponse login(@RequestParam String email,@RequestParam String password){
        AppUserEntity appUserEntity = appUserRepository.findByEmailAndPassword(email, password);
        if(appUserEntity != null){
            return new ApiLoginResponse("OK",email);
        }else{
            return new ApiLoginResponse("NOK",email);
        }
    }
}
