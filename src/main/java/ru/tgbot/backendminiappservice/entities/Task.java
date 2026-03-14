package ru.tgbot.backendminiappservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.tgbot.backendminiappservice.enums.TaskStatusEnum;
import ru.tgbot.backendminiappservice.enums.TaskTypeEnum;
import ru.tgbot.backendminiappservice.enums.TaskPriorityEnum;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    @NotNull
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @NotBlank
    @Column(name = "todo_time")
    private String todoTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @NotNull
    private TaskStatusEnum status;
    @NotNull
    private TaskTypeEnum type;
    @NotNull
    private TaskPriorityEnum priority;
}
