package manager;

import tasks.Task;


import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{
    ArrayList<Task> historyArray = new ArrayList<>();

    @Override
    public ArrayList<Task> getHistory(){ // Показывает историю
        return historyArray;
    }

    @Override
    public void add(Task task){
        System.out.println(task);
        if (historyArray.size() >= 10) historyArray.removeFirst();
        historyArray.add(new Task(task));
    }

}
