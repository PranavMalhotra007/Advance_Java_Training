package com.example.mobileapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.mobileapp.DTO.MobileDTO;
import com.example.mobileapp.entity.Mobile;
import com.example.mobileapp.exception.MobileNotFoundException;
import com.example.mobileapp.repository.MobileRepository;


@Service
public class MobileServiceImpl implements MobileService{
	@Autowired
	private MobileRepository mobileRepository;
	@Autowired
	private ModelMapper modelMapper;
	public MobileDTO entityToDTO(Mobile mobile) {
	    return modelMapper.map(mobile, MobileDTO.class);
	}
	public Mobile dtoToEntity(MobileDTO dto) {
	    return modelMapper.map(dto, Mobile.class);
	}
	public List<MobileDTO> listDTO(List<Mobile>employee){
		return employee.stream()
				.map(e->entityToDTO(e))
				.collect(Collectors.toList());
	}
	@Override
	@CachePut(value="mobiles", key = "#result.id")
	public MobileDTO saveMobile(MobileDTO mobile) {
		 Mobile m = mobileRepository.save(dtoToEntity(mobile));
		 return entityToDTO(m);
	}

	@Override
	public List<MobileDTO> findAllMobile() {
		List<Mobile> mobiles = mobileRepository.findAll();
		if(!mobiles.isEmpty()) {
			return listDTO(mobiles);
		}
		throw new MobileNotFoundException("Mobile Database is empty");
	}

	@Override
	public List<MobileDTO> findMobileByName(String name) {
		List<Mobile>mobiles = mobileRepository.getMobileByName(name);
		return listDTO(mobiles);
	}

	@Override
	@Cacheable(value="mobiles", key = "#id")
	public MobileDTO findMobileById(int id) {
		// TODO Auto-generated method stub
		Optional<Mobile> m= mobileRepository.findById(id);
		if(m.isPresent()) {
			return entityToDTO(m.get());
		}
		throw new MobileNotFoundException("No mobile with id = "+id+" is present in database");
	}

	@Override
	@CacheEvict(value="mobiles", key = "#id")
	public String deleteMobileById(int id) {
		// TODO Auto-generated method stub
		findMobileById(id);
		mobileRepository.deleteById(id);
		return "Mobile Deleted";
	}

	@Override
	@CachePut(value="mobiles", key = "#result.id")
	public MobileDTO updateMobileById(int id, MobileDTO m) {
		findMobileById(id);
		Mobile mobile = mobileRepository.save(dtoToEntity(m));
		return entityToDTO(mobile);
	}

}
