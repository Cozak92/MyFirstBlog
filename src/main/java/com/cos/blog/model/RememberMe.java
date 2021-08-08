package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RememberMe {
	@Id
	private String series;
	@Column(nullable =false, length = 300)
	private String username;
	@Column(nullable =false, length = 300)
	private String token;
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
