package m22t.ansdlsrb.m22tProject.service;

import m22t.ansdlsrb.m22tProject.data.dto.UserCheckDto;
import m22t.ansdlsrb.m22tProject.data.dto.UserInputDto;
import m22t.ansdlsrb.m22tProject.data.entity.ReserveEntity;
import m22t.ansdlsrb.m22tProject.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 중복이 있으면 거부
@Service
public class UserReservationServiceImpl implements UserReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public boolean is_valid(UserInputDto userInputDto) {
        List<ReserveEntity> entityList = new ArrayList<>();
        reservationRepository.findAll().forEach(entityList::add);

        for (ReserveEntity entity : entityList) {
            if (isMatching(entity, userInputDto)) {
                return false; // 일치하는 순간 false 반환
            }
        }

        return true; // 일치하는 것이 없을 때 true 반환

    }

    private boolean isMatching(ReserveEntity entity, UserInputDto userInputDto) {
        return entity.getPlace_id().equals(userInputDto.getPlace_id()) &&
                entity.getDate().equals(userInputDto.getDate()) &&
                entity.getReserve_time().equals(userInputDto.getReserve_time());
    }


    @Override
    public List<ReserveEntity> findMatchingUsers(UserCheckDto userCheckDto) {

        List<ReserveEntity> matchingUsers = new ArrayList<>();

        List<ReserveEntity> entityList = new ArrayList<>();
        reservationRepository.findAll().forEach(entityList::add);



        for (ReserveEntity entity : entityList) {
            if (isMatching(entity, userCheckDto)) {
                matchingUsers.add(entity);
            }
        }

        return matchingUsers;
    }

    private boolean isMatching(ReserveEntity entity, UserCheckDto userCheckDto) {
        return entity.getUser_name().equals(userCheckDto.getUser_name()) &&
                entity.getUser_phone_number().equals(userCheckDto.getUser_phone_number());
    }
}




