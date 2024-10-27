package repo;

public interface IRepository<ID,T> {
    public void add(ID key, T value);
    public void delete(ID key);
    public void modify(ID key, T value);
    public T findById(ID key);
    public Iterable<T> getAll();
}
