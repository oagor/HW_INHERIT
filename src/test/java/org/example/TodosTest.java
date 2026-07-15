import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSeveralTasks() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        SimpleTask task2 = new SimpleTask(2, "Купить хлеб");
        Meeting task3 = new Meeting(3, "Поход в магазин", "Продукты", "Сегодня");

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] actual = todos.search("Купить");
        Task[] expected = {task1, task2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneTask() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        Epic task2 = new Epic(2, new String[]{"Яйца", "Хлеб"});

        todos.add(task1);
        todos.add(task2);

        Task[] actual = todos.search("молоко");
        Task[] expected = {task1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNoTasks() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Купить молоко");
        Epic task2 = new Epic(2, new String[]{"Яйца", "Хлеб"});

        todos.add(task1);
        todos.add(task2);

        Task[] actual = todos.search("автобус");
        Task[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
