/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat3.jpademojon.entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author didas
 */
public class Tester {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        Person p1 = new Person("Jønke", 1963);
        Person p2 = new Person("Blondie", 1959);
        
        Address a1 = new Address("Store Torv 1", 2323, "Nr. Snede");
        Address a2 = new Address("Langgade 34", 1212, "Valby");      
        
        p1.setAddress(a1);
        p2.setAddress(a2); 
        
        Fee f1 = new Fee(100);
        Fee f2 = new Fee(200);
        Fee f3 = new Fee(300);
        
        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("ButterFly");
        SwimStyle s3 = new SwimStyle("Breast Stroke");
        
        p1.addSwimStyle(s1);
        p1.addSwimStyle(s3);
        p2.addSwimStyle(s2); 
        
        p1.addFee(f1);
        p1.addFee(f3);
        p2.addFee(f2);
        
        em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
            p1.removeSwimStyle(s3); 
        em.getTransaction().commit();
        
        System.out.println("p1: " + p1.getP_id() + ", " + p1.getName());
        System.out.println("p2: " + p2.getP_id() + ", " + p2.getName());
        
        System.out.println("Jønkes gade: " + p1.getAddress().getStreet());
        
        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName());
        
        System.out.println("Hvem har betalt f2? Det har: " + f2.getPerson().getName());
        
        System.out.println("Hvad er der blevet betalt i alt?");
        
        TypedQuery<Fee> q1 = em.createQuery("SELECT f from Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();
        for (Fee f : fees){
            System.out.println(f.getPerson().getName() + ": " + f.getAmount() + "kr. Den: " + f.getPayDate() + " Adr: " + f.getPerson().getAddress().getCity());
        }
        
        /*TypedQuery<Person> q2 = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = q2.getResultList();
        
        for (Person p: persons){
            System.out.println("Navn: " + p.getName());
            System.out.println("--Fees:");
            for (Fee f: p.getFees()){
                System.out.println("---- Beløb: " + f.getAmount() + ", " + f.getPayDate().toString() );
            }
            System.out.println("--Styles:");
            for (SwimStyle ss: p.getStyles()){
                System.out.println("---- Style: " + ss.getStyleName());
            }
        }
        
        System.out.println("**** Eksperimenter med JPQL");
        
        TypedQuery<PersonStyleDTO> q4 = em.createQuery("SELECT new dto.PersonStyleDTO(p.name, p.year, s.styleName) FROM Person p JOIN p.styles s", dto.PersonStyleDTO.class);
        List<PersonStyleDTO> personList =  q4.getResultList();
        
        for (PersonStyleDTO p: personList){
            System.out.println(p.getName() + ", " + p.getYear() + ", " + p.getSwimStyle());
        }*/
        
        populate(em);
        
        em.close();
    }
    
    public static void populate(EntityManager em){
    
        Person p3 = new Person("Jens", 1961);
        Person p4 = new Person("Ole", 1979);
        Person p5 = new Person("Bente", 1983);
        Person p6 = new Person("Dennis", 1939);
        Person p7 = new Person("Ida", 1990);
        Person p8 = new Person("Mette", 1999);
        Person p9 = new Person("Kaj", 1993);
        Person p10 = new Person("Finn", 2002);
        Person p11 = new Person("Charlotte", 2003);
        Person p12 = new Person("Karin", 1970);
        Person p13 = new Person("Gitte", 1975);
        Person p14 = new Person("Hans", 1989);
        
        Address a1 = new Address("Storegade 10", 2323, "Nr. Søby");
        Address a2 = new Address("Bredgade 14", 1212, "København K");
        Address a3 = new Address("Lillegade 1", 2323, "Nr. Søby");
        Address a4 = new Address("Damvej", 1212, "København K");
        Address a5 = new Address("Ndr Frihavnsgade 12", 2100, "Kbh Ø");
        Address a6 = new Address("Østerbrogade 85", 1212, "København K");
        Address a7 = new Address("Nørregade 4", 2200, "Nr. Søby");
        Address a8 = new Address("Nørregade 5", 2200, "København K");
        Address a9 = new Address("Odensegade 64", 2323, "Nr. Søby");
        Address a10 = new Address("Århusgade 29", 2300, "København S");
        
        p3.setAddress(a1);
        p4.setAddress(a2);
        p5.setAddress(a3);
        p6.setAddress(a4);
        p7.setAddress(a5);
        p8.setAddress(a6);
        p9.setAddress(a7);
        p10.setAddress(a8);
        p11.setAddress(a9);
        p12.setAddress(a10);
        p13.setAddress(a1);
        p14.setAddress(a2);
        
        
        Fee f1 = new Fee(100);
        Fee f2 = new Fee(200);
        Fee f3 = new Fee(300);
       
        p3.addFee(f1);
        p4.addFee(f3);
        p5.addFee(f2);
        p6.addFee(f1);
        p7.addFee(f3);
        p8.addFee(f2);
        p9.addFee(f1);
        p10.addFee(f3);
        p11.addFee(f2);
        p12.addFee(f1);
        p13.addFee(f3);
        p14.addFee(f2);
        
        em.getTransaction().begin();
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);
            em.persist(p6);
            em.persist(p7);
            em.persist(p8);
            em.persist(p9);
            em.persist(p10);
            em.persist(p11);
            em.persist(p12);
            em.persist(p13);
            em.persist(p14);
        em.getTransaction().commit();
    
    }
}
