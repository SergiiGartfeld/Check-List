package com.todo.checklist.controller;

import com.todo.checklist.model.CheckList;
import com.todo.checklist.model.dto.AddChecklistDto;
import com.todo.checklist.model.dto.CheckListDto;
import com.todo.checklist.services.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller

public class ChecklistController {
    @Autowired
    private CheckListService checkListService;

    @GetMapping("/checkListForm")
    public String getCheckListForm(){
        return "checklistForm";
    }

    @PostMapping("/checkListForm")
    public String submitChecklistForm(CheckListDto dto){
    Optional<CheckList>checkListOptional = checkListService.create(dto);
    if(checkListOptional.isPresent()){
        return "redirect:/";
    }
        return "redirect:/checklist/list";
    }
    @GetMapping("/list")
    public String getCheckListList(Model model){
    model.addAttribute("checkList", checkListService.checkListsFromDB());
        return "checklists";
    }
}
