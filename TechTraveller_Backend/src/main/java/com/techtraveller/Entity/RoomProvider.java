package com.techtraveller.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomProvider {
	 @Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private String id;

	    private String name;
	    private String contactNumber;
	    private String email;
	    private String address;
	    private String description; 
	    private double rating;
	    private String isVerified;
	    
	    @OneToOne(cascade = CascadeType.REMOVE)
	    @JoinColumn(name = "user_id", referencedColumnName = "userId",nullable=false)
	    private User user;
	    
	  
	    
	    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
	    @JsonManagedReference("roomProvider")
	    private List<LocalRoom> localRoom;
	    
}
