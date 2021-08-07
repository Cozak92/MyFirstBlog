package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 읽어서 자동으로 Mysql에 자동으로 테이블이 생성
public class User {
	
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //auto increment
	
	
	@Column(nullable =false, length = 30,unique = true)
	private String username;
	@Column(nullable =false, length = 100)
	private String password;
	@Column(nullable =false, length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; //ENUM을 쓰는게 좋다
	
	@CreationTimestamp
	private Timestamp createDate;
	

}
