package com.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bank.entity.BranchEntity;
import com.bank.model.BranchDTO;

@Mapper
public interface BranchMapper {

//	@Mapping(target = "accountDTOs", source = "accountEntities")
	BranchDTO toDto(BranchEntity entity);

//	@Mapping(target = "accountEntities", source = "accountDTOs")
	BranchEntity toEntity(BranchDTO dto);
	
    List<BranchDTO> toDtoList(List<BranchEntity> entityList);

    List<BranchEntity> toEntityList(List<BranchDTO> dtoList);
}
