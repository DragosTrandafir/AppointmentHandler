package repo;

import filter.AbstractFilter;

// special repository which will contain only objects respecting a certain filter
public class FilteredRepository<ID,T> extends MemoryRepository<ID,T> {

    private AbstractFilter<T> filter;
    public FilteredRepository(AbstractFilter<T> filter){
        this.filter=filter;
    }

    @Override
    public void add(ID key, T value) {
        // // add objects with a certain key only if it doesnt exist already and with a value that is accepted by the filter
        if (filter.accept(value) && !appointments.containsKey(key))
            appointments.put(key, value);
    }
    @Override
    // // modify objects with a value that is accepted by the filter
    public void modify(ID key, T value){
        if (filter.accept(value))
            appointments.put(key,value);
    }
}
