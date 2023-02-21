package sn.esmt.scolarite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.scolarite.entities.AppUserEntity;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity,Integer> {
    AppUserEntity findById(int id);
    AppUserEntity findByEmailAndPassword(String email, String password);

}
