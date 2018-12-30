package com.todo.checklist.controller;

import com.todo.checklist.model.CheckList;
import com.todo.checklist.model.dto.CheckListDto;
import com.todo.checklist.services.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
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
    model.addAttribute("checkLi", checkListService.getAll());

        return "checklists";
    }
    @GetMapping("/remove")
    public String removeCheckList(@RequestParam(name = "checkListToRemove") Long id){
        checkListService.remove(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{identifier}")
    public String getEditForm(Model model, @PathVariable(name = "identifier")Long id){
        Optional<CheckListDto>checkListDto = checkListService.getById(id);
        CheckListDto checkListDto1 = checkListDto.get();
        if(checkListDto.isPresent()){
            model.addAttribute("archivedCheck", checkListDto1.isArchivedCheck());
            model.addAttribute("checkListToEdit", checkListDto.get());
            return "checkListEditForm";
        }
        return "redirect:/list";
    }
    @PostMapping("/edit/{identifier}")
    public String getEditForm(Model model, @PathVariable(name = "identifier")Long id ,CheckListDto dto){
       checkListService.update(dto);
       return "redirect:/list";
    }
    @GetMapping("/archived")
    public String getCheckListListArchived(Model model){
       model.addAttribute("checkLis", checkListService.getArchived());
        return "checkListsArchived";
    }
}
