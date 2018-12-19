package com.todo.checklist.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime dateTimeCreated;


    private LocalDateTime dateTimeCompleted;

    private boolean archived;

    @OneToMany(mappedBy = "checkLists", fetch = FetchType.EAGER)
    private List<CheckListItem>checkListItems;

}
