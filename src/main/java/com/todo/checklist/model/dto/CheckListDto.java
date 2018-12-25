package com.todo.checklist.model.dto;

import com.todo.checklist.model.CheckListItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Getter

@AllArgsConstructor
@NoArgsConstructor
public class CheckListDto {
    private Long idCheck;


    private String nameCheck;


    private LocalDateTime dateCreatedCheck;


    private LocalDateTime dateCompletedCheck;

    private boolean archivedCheck;


    private Set<CheckListItem> checklistItemSetCheck;
}
