package com.todo.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CheckListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateCompleted;
    private Status status;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private CheckList checkLists;

    @OneToMany(mappedBy = "checkListItem", fetch = FetchType.EAGER)
    private List<Notes>notes;
}
