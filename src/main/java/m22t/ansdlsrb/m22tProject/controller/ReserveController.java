package m22t.ansdlsrb.m22tProject.controller;

import m22t.ansdlsrb.m22tProject.data.dto.UserInputDto;
import m22t.ansdlsrb.m22tProject.data.entity.UserEntity;
import m22t.ansdlsrb.m22tProject.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ReserveController {

    private final ReservationRepository reservationRepository;
    @Autowired
    public ReserveController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/check-reserve") // 이 주소로 post 요청을 하면 예약 정보 db 저장
    public ResponseEntity<?> checkReservation(@RequestBody UserInputDto userInputDto) {
        try {
            // DTO 객체로부터 예약 정보를 추출하여 DB에 저장
            UserEntity user = new UserEntity();
            user.setUser_name(userInputDto.getUser_name());
            user.setUser_phone_number(userInputDto.getUser_phone_number());
            user.setPlace_id(userInputDto.getPlace_id());
            user.setDate(userInputDto.getDate());
            user.setReserve_time(userInputDto.getReserve_time());

            reservationRepository.save(user);

            return ResponseEntity.ok().body("{\"success\": true}");
        } catch (Exception e) {
            // 에러 응답을 JSON 형식으로 생성하여 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"An error occurred while processing the request.\"}");
        }
    }


}