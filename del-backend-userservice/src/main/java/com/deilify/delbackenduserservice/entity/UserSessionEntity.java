package com.deilify.delbackenduserservice.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingsession")
public class UserSessionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "total")
	private Float total;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "modifie_at")
	private LocalDate modifiedAt;
	
	@ManyToOne
	@JoinColumn(name = "user_entity_id", referencedColumnName = "userId", insertable = false, updatable = false)
	private UserEntity userEntity;
	

}
