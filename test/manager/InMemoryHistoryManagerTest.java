package manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tasks.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InMemoryHistoryManagerTest {
        private HistoryManager historyManager;
        private Task taskA;
        private Task taskB;
        private Task taskC;
        private Task taskD;

        @BeforeEach
        void beforeEachTest() {
            historyManager = Manager.getDefaultHistory();
            taskA = new Task("Task A", "Description A");
            taskB = new Task("Task B", "Description B");
            taskC = new Task("Task C", "Description C");
            taskD = new Task("Task D", "Description D");
            taskA.setId(1);
            taskB.setId(2);
            taskC.setId(3);
            taskD.setId(4);
        }

}
