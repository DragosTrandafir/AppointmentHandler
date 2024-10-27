package repo;

import java.util.HashMap;

// generic repository for any type of objects ,structured as a hashmap
public class MemoryRepository<ID,T> implements IRepository<ID, T> {
    protected HashMap<ID,T> appointments= new HashMap<>();

    public void add(ID key, T value){
        // add objects with a certain key only if it doesnt exist already
        if(!appointments.containsKey(key))
            appointments.put(key,value);
    }
    public void delete(ID key){
        appointments.remove(key);
    }
    public void modify(ID key, T value){
        appointments.put(key,value);
    }
    public T findById(ID key){
        return appointments.get(key);
    }
    public Iterable<T> getAll(){
        return appointments.values();
    }
    public void printALl(){
        Iterable<T> values = this.getAll();
        for(T value: values)
            System.out.println(value);
    }

}