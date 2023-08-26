package m22t.ansdlsrb.m22tProject.data.repository;

import m22t.ansdlsrb.m22tProject.data.entity.PlaceEntity;
import m22t.ansdlsrb.m22tProject.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReservationRepository extends CrudRepository<UserEntity, Long> {



}
