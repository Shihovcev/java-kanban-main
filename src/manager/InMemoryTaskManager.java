package manager;
import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager{

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtask = new HashMap<>();
    private HashMap<Integer, Epic> epic = new HashMap<>();
    ArrayList<Integer> historyArray = new ArrayList<>();

    @Override
    public ArrayList<Task> getAllTask(){ // Показать все задачи
        return new ArrayList<>(tasks.values());
    }

    @Override
    public ArrayList<Task> getAllSubtask(){ // Показать все подзадачи
        return new ArrayList<>(subtask.values());
    }

    @Override
    public ArrayList<Task> getAllEpic(){ // Показать все эпики
        return new ArrayList<>(epic.values());
    }

    @Override
    public void deleteAllTask(){ // удаление всех задач
        tasks.clear();
    }

    @Override
    public void deleteAllSubtask(){ // удаление всех подзадач
        for (Subtask subtask : subtask.values()) {
            subtask.getEpicTask().removeSubtask(subtask);
            subtask.getEpicTask().updateStatus();
        }
        subtask.clear();

    }

    @Override
    public void deleteAllEpic(){ // удаление всех эпиков
        epic.clear();
        deleteAllSubtask();
    }

    @Override
    public Task getTaskById(Integer taskId){ // Возвращаем по ID задачу
        addHistory(taskId);
        return tasks.get(taskId);
    }

    @Override
    public Subtask getSubtaskById(Integer taskId){ // Возвращаем по ID подзадачи
        addHistory(taskId);
        return subtask.get(taskId);
    }

    @Override
    public Epic getEpicById(Integer taskId){ // Возвращаем по ID Эпики
        addHistory(taskId);
        return epic.get(taskId);
    }

    @Override
    public void addTask(Task task){ // создание новой задачи
        tasks.put(task.getId(), task);
    }

    @Override
    public void addEpic(Epic epic){ // создание нового эпика
        this.epic.put(epic.getId(), epic);
    }

    @Override
    public void addSubtask(Subtask subtask){ // создание новой подзадачи
        this.subtask.put(subtask.getId(), subtask);
    }

    @Override
    public void updateTask (Task task){ // Обновление задачи
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic){   // обновлние эпика
        epic.updateStatus();
        this.epic.put(epic.getId(), epic);
    }

    @Override
    public void updateSubtask(Subtask subtask){ // обновление подзадачи
        subtask.getEpicTask().updateStatus();
        this.subtask.put(subtask.getId(), subtask);
    }

    @Override
    public void deleteTaskById (Integer id){ //удаление задачи по ID
        tasks.remove(id);
    }

    @Override
    public void deleteSubtaskById (Integer id){ //удаление подзадачи по ID
        subtask.get(id).getEpicTask().removeSubtask(subtask.get(id));
        this.subtask.remove(id);
    }

    @Override
    public void deleteEpicById (Integer id){ // удаление эпика по ID
        for (Subtask subtask : epic.get(id).getSubtaskList()) {
            this.subtask.remove(subtask.getId());
        }
        this.epic.remove(id);
    }

    @Override
    public ArrayList<Task> getHistory(){
        ArrayList<Task> history = new ArrayList<>();
        for (Integer story : historyArray) {
            for (Integer task : tasks.keySet()) {
                if (story == task){
                    history.add(tasks.get(story));
                }
            }
            for (Integer task : subtask.keySet()) {
                if (story == task){
                    history.add(subtask.get(story));
                }
            }
            for (Integer task : epic.keySet()) {
                if (story == task){
                    history.add(epic.get(story));
                }
            }
        }
        return history;
    }
    
    public void addHistory(Integer id){
        if(historyArray.size() < 10){
            historyArray.add(id);
        }else {
            historyArray.remove(0);
            historyArray.add(id);
        }
    }
}
