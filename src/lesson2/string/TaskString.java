package lesson2.string;

import lesson2.ITask;

public class TaskString  implements ITask {
    @Override
    public String run(String[] data) {
        return String.valueOf(data[0].length());
    }
}
