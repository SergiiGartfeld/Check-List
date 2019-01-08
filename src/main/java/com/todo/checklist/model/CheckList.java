package com.todo.checklist.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 50)
    private String name;

    @CreationTimestamp
    private LocalDateTime dateCreated;


    private LocalDateTime dateCompleted;

    private boolean archived;

    @OneToMany(mappedBy = "checkList", fetch = FetchType.EAGER)
    private Set<CheckListItem> checklistItemSet = new HashSet<>();

}
