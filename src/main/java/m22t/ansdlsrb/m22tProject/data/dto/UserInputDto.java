package m22t.ansdlsrb.m22tProject.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDto { // 예약자로 부터 받아올 데이터

    private String user_name;

    private String user_phone_number;
    private Long place_id;
    private String date;
    private Integer reserve_time;


}
