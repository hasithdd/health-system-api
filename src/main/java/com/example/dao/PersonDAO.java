package com.example.dao;

import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static List<Person> persons = new ArrayList<>();
    
    static {
        persons.add(new Person(1,"Kamal","0711111111","1,Galle Road,Colombo"));
        persons.add(new Person(2,"Nimal","0712222222","2,Galle Road,Colombo"));
    }
    
    public List<Person> getAllPersons(){
        return persons;
    }
    
    public Person getPersonById(int id){
        for (Person person : persons){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }
    
    public void addPerson(Person person){
        int newUserId = getNextUserId();
        person.setId(newUserId);
        persons.add(person);
    }
    
    public void updatePerson(Person updatedPerson){
        for(int i=0 ; i < persons.size() ; i++){
            Person person = persons.get(i);
            if(person.getId() == updatedPerson.getId()) {
                persons.set(i,updatedPerson);
                System.out.println("Person updated: " + updatedPerson);
                return;
            }
        }
    }
    
    public void deletePerson(int id){
        persons.removeIf(person -> person.getId() == id);
    }
    
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (Person person : persons){
            int userId = person.getId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
}
