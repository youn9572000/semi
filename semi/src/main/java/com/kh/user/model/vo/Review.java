package com.kh.user.model.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Builder

public class Review {
    private int reviewNo;
    private String reviewWriter;
    private int productNo;
    private String reviewContent;
    private Date reviewDate;
    private int reviewScore;
		
	}
    // Getters and Setters
