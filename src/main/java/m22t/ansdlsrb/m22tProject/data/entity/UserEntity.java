package m22t.ansdlsrb.m22tProject.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="User_table")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_name; // 예약자 이름
    private String user_phone_number; // 예약자의 전화번호
    private Long place_id;  // 예약 장소의 고유키 (id)
    private String date; // 예약 날짜
    private Integer reserve_time; // 타입으로 갈것이며 시간대 별로 나누게 될 것이다. 0 정규시간, 1 심야시간
}
