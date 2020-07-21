package com.myjava.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;

import com.myjava.msscbeerservice.domain.Beer;
import com.myjava.msscbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto BeerToBeerDto(Beer beer);
	
	Beer BeerDtoToBeer(BeerDto dto);
}
