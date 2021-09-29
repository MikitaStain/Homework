package by.it_academy.hibernate.dao;

public interface IDAO<Entity,Key> {

    void create(Entity entity);
    Entity read(Key key);
    void update(Entity entity);
    void delete(Entity entity);
}
