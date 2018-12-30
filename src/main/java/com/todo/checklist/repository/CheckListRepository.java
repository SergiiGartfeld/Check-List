package com.todo.checklist.repository;

import com.todo.checklist.model.CheckList;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Long> {
List<CheckList>findCheckListsByArchivedIsTrue();
}
