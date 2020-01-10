package service;

import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {
    private HibernateUtil util = new HibernateUtil();
    private Session session;

    public User getUserByID(int id){
        session = util.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
    public List<User> getAllUsers(){
        session = util.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("from User").list();
        session.close();
        return users;
    }

    public void newUser(User user){
        session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public User getUserByLogin(String login){
        session = util.getSessionFactory().openSession();
        //List<User> users = (List<User>) session.createQuery("from User").list();
        //User user = (User) session.createQuery("from User where login = '" + login + "'");
        Query query = session.createQuery("from User where login = :param");
        query.setParameter("param", login);
        List<User> list = query.list();
        session.close();
        return list.get(0);
    }
}
