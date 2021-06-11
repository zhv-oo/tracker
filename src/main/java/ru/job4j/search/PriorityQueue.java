package ru.job4j.search;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (tasks.size() == 0) {
            tasks.add(index, task);
        } else {
            for (Task element : tasks) {
                if (element.getPriority() >= task.getPriority()) {
                    tasks.add(index, task);
                } else {
                    tasks.add(index + 1, task);
                }
                break;
            }
        }
    }

    public Task take() {
        return tasks.poll();
    }
}