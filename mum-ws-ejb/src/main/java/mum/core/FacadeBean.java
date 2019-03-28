package mum.core;

import org.hibernate.Session;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;

public class FacadeBean {
    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    @Resource
    protected SessionContext sessionContext;

    protected Session session;

    protected SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
    protected SimpleDateFormat smtHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected boolean isValid(String str) {
        return str != null && !str.isEmpty();
    }
}
