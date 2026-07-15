import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    void shouldMatchSimpleTaskByTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        assertTrue(task.matches("родителям"));
        assertFalse(task.matches("магазин"));
    }

    @Test
    void shouldMatchEpicBySubtasks() {
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца", "Хлеб"});

        assertTrue(epic.matches("Яйца"));
        assertFalse(epic.matches("Кофе"));
    }

    @Test
    void shouldMatchMeetingByTopicOrProject() {
        Meeting meeting = new Meeting(3, "Выкатка версии", "Приложение НетоБанка", "Во вторник");

        assertTrue(meeting.matches("Выкатка"));
        assertTrue(meeting.matches("НетоБанка"));
        assertFalse(meeting.matches("Пятница"));
    }
}
