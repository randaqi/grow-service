package com.oocl.grow.repository;

import com.oocl.grow.model.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryIntegrationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test(expected = Exception.class)
    public void shouldThrowException_givenDescNull_whenCreate() {
        //given
        Task task = new Task();

        //when
        taskRepository.save(task);

    }
}
