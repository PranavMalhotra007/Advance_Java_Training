package com.example.mobileapp.service;

import java.util.List;


import com.example.mobileapp.DTO.MobileDTO;

public interface MobileService {
	MobileDTO saveMobile(MobileDTO mobile);
	List<MobileDTO> findAllMobile();
	List<MobileDTO> findMobileByName(String name);
	MobileDTO findMobileById(int id);
	String deleteMobileById(int id);
	MobileDTO updateMobileById(int id,MobileDTO m);
}
