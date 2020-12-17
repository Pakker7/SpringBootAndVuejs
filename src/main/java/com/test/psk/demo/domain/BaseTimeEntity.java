package com.test.psk.demo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Getter
@MappedSuperclass // jpa entity 클래스들이 baseTimeEntity를 상속할 경우 필드(createdDate, modifiedDate)들도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //base time entity 클래스에 auditing 기능을 포함시킴
public class BaseTimeEntity { //모든 entity의 상위클래스가 되어 Entity들의 createDate, modifiedDate를 자동으로 관리하는 역할

    @CreatedDate
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;


}
