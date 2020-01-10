package service;

import hibernate.HibernateUtil;
import model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FilmService {
    private HibernateUtil util = new HibernateUtil();
    private Session session;

    public List<Film> getAllFilms(){
        session = util.getSessionFactory().openSession();
        List<Film> films = (List<Film>) session.createQuery("from Film").list();
        session.close();
        return films;
    }
}
