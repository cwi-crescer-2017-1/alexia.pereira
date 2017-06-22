package br.com.crescer.aula3.DAO;

/**
 * @author carloshenrique
 */
public interface DAO<T> {
    
    void insert(T t);

    void update(T t);

    void delete(T t);
    
    T loadBy(Long id);

}
