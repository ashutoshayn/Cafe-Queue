/**
 *
 * @author Ashutosh Aryan
 * @version 09/06/2026
 */

import java.util.ArrayList; 
public class CafeQueue
{
    private ArrayList<Person> queue;
    public CafeQueue(){
        queue = new ArrayList<Person>();
    }
    
    public boolean queueEmpty(){
        return queue.size() == 0;
    }
    
    public void enqueue(Person person) {
        if (person.isTeacher()) {
            int insertIndex = 0;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i).isTeacher()) {
                    insertIndex = i + 1;
                }
            }
            queue.add(insertIndex, person);
        } else {
            queue.add(person);
        }
    }
    
    public Person dequeue(){
        if (queueEmpty()){
            return null;
        }
        return queue.remove(0);
    }
    
    public ArrayList<Person> getQueue() {
        return queue;
    }
}