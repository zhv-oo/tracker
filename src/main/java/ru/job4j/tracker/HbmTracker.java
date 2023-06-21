package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean res = true;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "update Item i set i.name = :fname, "
                                    + "i.created = :fcreated where i.id = :fid")
                    .setParameter("fname", item.getName())
                    .setParameter("fcreated", item.getId())
                    .setParameter("fid", item.getId())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    @Override
    public boolean delete(int id) {
        boolean res = true;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("delete Item where Item.id = :fid")
                    .setParameter("fid", id).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = null;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = null;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery("from Item as i where i.name = :fkey", Item.class)
                    .setParameter("fkey", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            item = session.createQuery(
                            "from Item as i where i.id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    @Override
    public void init() {

    }
}