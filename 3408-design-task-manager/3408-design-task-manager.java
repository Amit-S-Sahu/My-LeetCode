class TaskManager {
    class Task implements Comparable<Task> {
        int taskId;
        int priority;

        Task(int taskId, int priority) {
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task t2) {
            if (this.priority != t2.priority) return t2.priority - this.priority;
            return t2.taskId - this.taskId;
        }
    }
    Map<Task, Integer> userList;
    Map<Integer, Task> taskList;
    PriorityQueue<Task> priorityList;
    Set<Task> deleted;

    public TaskManager(List<List<Integer>> tasks) {
        userList = new HashMap<>();
        priorityList = new PriorityQueue<>();
        taskList = new HashMap<>();
        deleted = new HashSet<>();

        for (List<Integer> t : tasks) {
            Task temp = new Task(t.get(1), t.get(2));
            userList.put(temp, t.get(0));
            priorityList.add(temp);
            taskList.put(t.get(1), temp);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task temp = new Task(taskId, priority);
        userList.put(temp, userId);
        priorityList.add(temp);
        taskList.put(taskId, temp);
    }
    
    public void edit(int taskId, int newPriority) {
        Task temp = taskList.get(taskId);
        if (temp == null) return;
        deleted.add(temp);
        Task newer = new Task(taskId, newPriority);
        taskList.put(taskId, newer);
        userList.put(newer, userList.remove(temp));
        priorityList.add(newer);
    }
    
    public void rmv(int taskId) {
        Task temp = taskList.get(taskId);
        userList.remove(temp);
        taskList.remove(taskId);
        deleted.add(temp);        
    }
    
    public int execTop() {
        while (!priorityList.isEmpty()){
            Task t = priorityList.poll();
            if (deleted.remove(t)) continue;
            Integer user = userList.remove(t);
            taskList.remove(t.taskId);
            return (user == null) ? -1 : user;
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */