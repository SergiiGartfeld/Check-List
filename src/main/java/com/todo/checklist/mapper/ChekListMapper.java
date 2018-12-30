package com.todo.checklist.mapper;

import com.todo.checklist.model.CheckList;
import com.todo.checklist.model.dto.CheckListDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ChekListMapper {
    @Mappings(value = {
            @Mapping(source = "id", target = "idCheck"),
            @Mapping(source = "name", target = "nameCheck"),
            @Mapping(source = "dateCreated", target = "dateCreatedCheck"),
            @Mapping(source = "dateCompleted", target = "dateCompletedCheck"),
            @Mapping(source = "archived", target = "archivedCheck"),
            @Mapping(source = "checklistItemSet", target = "checklistItemSetCheck"),

    })
    CheckListDto  checkListToCheckListDto(CheckList checkList);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "nameCheck"),
            @Mapping(target = "dateCreated", ignore = true),
            @Mapping(target = "dateCompleted", source = "dateCompletedCheck"),
            @Mapping(target = "archived", source = "archivedCheck"),
            @Mapping(target = "checklistItemSet", source = "checklistItemSetCheck"),

    })
    CheckList  checkListDtoToNewCheckList(CheckListDto dto);



    @Mappings(value = {
            @Mapping(target = "id", source = "idCheck"),
            @Mapping(target = "name", source = "nameCheck"),
            @Mapping(target = "dateCreated", source = "dateCreatedCheck"),
            @Mapping(target = "dateCompleted", source = "dateCompletedCheck"),
            @Mapping(target = "archived", source = "archivedCheck"),
            @Mapping(target = "checklistItemSet", source = "checklistItemSetCheck"),
    })
    CheckList checkListDtoToCheckList(CheckListDto dto);





}
