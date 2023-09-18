package m22t.ansdlsrb.m22tProject.service;

import m22t.ansdlsrb.m22tProject.data.dto.FrontendDto;
import m22t.ansdlsrb.m22tProject.data.dto.PlaceDto;
import m22t.ansdlsrb.m22tProject.data.dto.UserCheckDto;
import m22t.ansdlsrb.m22tProject.data.dto.UserInputDto;
import m22t.ansdlsrb.m22tProject.data.entity.ReserveEntity;
import m22t.ansdlsrb.m22tProject.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface UserReservationService {

    public boolean is_valid(UserInputDto userInputDto);
    public List<ReserveEntity> findMatchingUsers(UserCheckDto userCheckDto);



}
