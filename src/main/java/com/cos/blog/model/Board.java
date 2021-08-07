package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100) // 제목
	private String title;
	
	@Lob
	private String content; // 섬머노트 라이브러리 -> html 태그 섞여서 디자인이므로 용량 큼
	
	@ColumnDefault("0") // 조회수
	private int count;
	
	@ManyToOne // many = Board , User = one
	@JoinColumn(name="userId")
	private User user; //DB는 오브젝트를 저장할수 없어서 FK를 사용하지만 ORM을 사용할때는 오브젝트로 사용한다
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
}
