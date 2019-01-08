package com.todo.checklist.repository;

import com.todo.checklist.model.CheckListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckListItemRepository extends JpaRepository<CheckListItem, Long> {
    Optional<CheckListItem> findCheckListItemByContent(String s);
}
