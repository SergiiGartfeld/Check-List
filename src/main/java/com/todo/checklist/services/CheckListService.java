package com.todo.checklist.services;

import com.todo.checklist.mapper.ChekListMapper;
import com.todo.checklist.model.CheckList;
import com.todo.checklist.model.CheckListItem;
import com.todo.checklist.model.dto.AddChecklistDto;
import com.todo.checklist.model.dto.CheckListDto;
import com.todo.checklist.repository.CheckListItemRepository;
import com.todo.checklist.repository.CheckListRepository;
import lombok.extern.java.Log;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@Log
public class CheckListService {
    @Autowired
    private CheckListRepository checkListRepository;
    @Autowired
    private CheckListItemRepository itemRepository;

    @Autowired
    private ChekListMapper chekListMapper;

    public Optional<CheckList>create(CheckListDto dto){
        CheckList checkList =chekListMapper.checkListDtoToCheckList(dto);
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
    public void update(CheckListDto dto){
        CheckList checkList = chekListMapper.checkListDtoToCheckList(dto);
        checkListRepository.save(checkList);
    }
    public void remove(Long id){
        checkListRepository.deleteById(id);
    }
    public Optional<CheckListDto>getById(Long id){
        Optional<CheckList>checkListOptional = checkListRepository.findById(id);
        return checkListOptional.map(checkList -> chekListMapper.checkListToCheckListDto(checkList));
    }

    public List<CheckListDto>getArchived(){

        return checkListRepository
                .findCheckListsByArchivedIsTrue()
                .stream()
                .map(checkList -> chekListMapper.checkListToCheckListDto(checkList))
                .collect(Collectors.toList());

    }



    public Optional<CheckListItem>createItem(AddChecklistDto dto, Long id){

        CheckListItem checkListItem = new CheckListItem();
        checkListItem.setContent(dto.getCheckListName());
        if(!checkListItem.getContent().isEmpty()&&checkListItem.getContent()!=null) {
            Optional<CheckList> checkListOptional = checkListRepository.findById(id);
            if (checkListOptional.isPresent()) {
                CheckList checkList = checkListOptional.get();
                checkList.getChecklistItemSet().add(checkListItem);
                checkListRepository.save(checkList);
                checkListItem.setCheckList(checkList);
                return Optional.of(itemRepository.save(checkListItem));
            }
        }
        return Optional.empty();
    }

}


