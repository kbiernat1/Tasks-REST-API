package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @InjectMocks
    TaskMapper taskMapper;

    @Test
    void mapToTaskTest() {
        //given
        TaskDto taskDto = new TaskDto(1L, "test_task", "test_content");
        //when
        Task task = taskMapper.mapToTask(taskDto);
        //then
        Assertions.assertEquals(taskDto.getId(), task.getId());
    }

    @Test
    void mapToTaskDtoTest() {
        //given
        Task task = new Task(1L, "test_task", "test_content");
        //when
        TaskDto taskdto = taskMapper.mapToTaskDto(task);
        //then
        Assertions.assertEquals(task.getId(), taskdto.getId());
    }

    @Test
    void mapToTaskDtoListTest() {
        //given
        List<Task> taskList = Arrays.asList(new Task(1L, "test_task", "test_content"), new Task(2L, "test_task_2", "test_content_2"));
        //when
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //then
        Assertions.assertEquals(taskList.get(1).getId(), taskDtoList.get(1).getId());
    }
}
