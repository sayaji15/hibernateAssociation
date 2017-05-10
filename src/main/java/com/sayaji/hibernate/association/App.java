package com.sayaji.hibernate.association;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.sayaji.hibernate.association.model.Phone;
import com.sayaji.hibernate.association.model.Student;

public class App 
{
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory()
	{
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	public static void main( String[] args )
    {
        Set<Phone> phoneNumbers = new HashSet<Phone>();
        phoneNumbers.add(new Phone("cell", "666-777-9999"));
        phoneNumbers.add(new Phone("landline", "444-555-6666"));
        
        Student student = new Student("Sayaji", "Patil", phoneNumbers);
        save(student);
        
        List<Student> students = fetchAll();
        System.out.println("Size is "+ students.size());
        for(Student s : students)
        {
        	System.out.println(s);
        }
    }

	@SuppressWarnings("unchecked")
	private static List<Student> fetchAll()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}

	private static void save(Student student)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
}
