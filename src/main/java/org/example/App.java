package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//
//            List<Item> items = person.getItems();
//            for(Item item: items){
//                System.out.println(item);
//            }

//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);

//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Hibernate", person);
//            person.getItems().add(newItem); //best practice
//            session.save(newItem);
//
//            session.getTransaction().commit();


            //create person and item
//            Person person = new Person("name2", 19);
//            Item item = new Item("H3", person);
//            person.setItems(new ArrayList<Item>(Collections.singletonList(item)));
//
//            //session.save(person);
//            session.save(item);

            //deleting item
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            for (Item item: items) {
//                session.remove(item);
//            }
//            person.getItems().clear();


            //delete person
//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null));

            //change ouner of item
            Person person = session.get(Person.class, 3);
            Item item = session.get(Item.class, 9);
            item.getOwner().getItems().remove(item);
            item.setOwner(person);
            person.getItems().add(item);



            session.getTransaction().commit();

            System.out.println("after");

//            items = person.getItems();
//            for(Item item: items){
//                System.out.println(item);
//            }

        }

    }
}
