package com.todo.checklist.model.dto;


import com.todo.checklist.model.CheckList;
import com.todo.checklist.model.Notes;
import com.todo.checklist.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddChecklistDto {
    private Long idItem;
    private LocalDateTime itemTimeCompleted;
    private Status statusItem;
    private String checkListName;
    private CheckList checkListItem;
    private Set<Notes> notesItem;
}
