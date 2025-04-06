package org.batch.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "rltm")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RltmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String crtYmd;      // 생성_일자
    private String crtHhmm;     // 생성_시분
    private String linkId;      // 링크_ID
    private double linkLngt;    // 링크_길이
    private double passSped;    // 통행_속도
    private int passHr;         // 통행_시간
    private int vmtc;           // 차량 통행 수
}
