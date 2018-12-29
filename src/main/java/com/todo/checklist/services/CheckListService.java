package com.todo.checklist.services;

import com.todo.checklist.mapper.ChekListMapper;
import com.todo.checklist.model.CheckList;
import com.todo.checklist.model.dto.CheckListDto;
import com.todo.checklist.repository.CheckListRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@Log
public class CheckListService {
@Autowired
    private CheckListRepository checkListRepository;

@Autowired
private ChekListMapper chekListMapper;

public Optional<CheckList>create(CheckListDto dto){
    CheckList checkList =chekListMapper.checkListDtoToNewCheckList(dto);
    checkList = checkListRepository.save(checkList);
try{
    return Optional.of(checkListRepository.saveAndFlush(checkList));
} catch (Exception cvee){
    log.log(Level.SEVERE, "Duplikat.");
}
    return Optional.empty();
}

public List<CheckListDto> getAll(){
    return checkListRepository
            .findAll()
            .stream()
            .map(checkList -> chekListMapper.checkListToCheckListDto(checkList))
            .collect(Collectors.toList());
}
}
