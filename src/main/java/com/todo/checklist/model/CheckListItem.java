package com.todo.checklist.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private LocalDateTime itemDateCompleted;

    private Status status;

    @Length(max = 300)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private CheckList checkList;

    @OneToMany(mappedBy = "checkListItem", fetch = FetchType.EAGER)
    private Set<Notes> notes;
}
