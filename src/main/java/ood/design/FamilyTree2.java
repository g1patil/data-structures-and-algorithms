package ood.design;

import java.util.*;

public class FamilyTree2 {

    private Person root;
    private Map<Integer, Set<Person>> parentMap;


    public FamilyTree2(Person r){
        this.root = r;
        this.parentMap = new TreeMap<>();
        buildParentMap(this.root,this.parentMap);

    }

    private void buildParentMap(Person parent, Map<Integer, Set<Person>> map){
        if(parent == null || parent.children.isEmpty())
            return;

        for(Person child : parent.children){
            map.putIfAbsent(child.id,new HashSet<>());
            map.get(child.id).add(parent);
            if(parent.partner !=null)
                map.get(child.id).add(parent.partner);
            buildParentMap(child,map);
        }
    }

    public List<Person> getGrandChilds(Person person){
        List<Person> gc = new ArrayList<>();
        if(person.children.isEmpty())
            return gc;

        for(Person c1 : person.children){
            if(c1.children.isEmpty())
                continue;
            gc.addAll(c1.children);
        }
        return gc;
    }

    public Set<Person> getParent(Person person){
        return parentMap.get(person.id);
    }

    public Set<Person> getGreatParent(Person person){
        Set<Person> result = new HashSet<>();
        Set<Person> parents = parentMap.get(person.id);
        if(parents.isEmpty())
            return result;
        for(Person parent1 : parents){
            Set<Person> parent2 = parentMap.get(parent1.id);
            result.addAll(parent2);
        }
        return result;
    }

    public List<Person> getChildren(Person person){
        return person.children;
    }

    public Person findPerson(Person current , Person target){
        if(current == null)
            return null;
        if(current.id == target.id)
            return current;

        for(Person child : current.children){
            Person foundChild = findPerson(child , target);
            if(foundChild != null)
                return foundChild;
        }
        return null;
    }

    public List<Person> findPerson(Person target){
        System.out.println(
                findPerson(root,target)
        );
        return null;
    }

    public static class Person{
        public String name;
        public int id;
        public List<Person> children;
        public Person partner;

        public Person(int id,String n){
            this.id = id;
            this.name= n;
            children = new ArrayList<>();
        }

        public void setPartner(Person p){
            this.partner = p;
        }

        @Override
        public String toString(){
            return "Person{"+
                    "name='"+name+'\''+
                    ", id="+id+
                    '}';
        }
    }

    public static void main(String[] args){
        Person root = new Person(0,"a");
        Person root1 = new Person(01,"a1");

        root.setPartner(root1);
        root1.setPartner(root);

        Person p1 = new Person(1,"b");
        Person p2 = new Person(2,"c");
        Person p3 = new Person(3,"d");

        p1.setPartner(p3);
        p3.setPartner(p1);

        Person p4 = new Person(4,"e");
        Person p5 = new Person(5,"f");
        Person p6 = new Person(6,"g");

        root.children.add(p1);
        root.children.add(p2);

        p1.children.add(p4);
        p2.children.add(p5);
        p3.children.add(p6);

        FamilyTree2 tree = new FamilyTree2(root);

        System.out.println(
                tree.getParent(p4)
        );
    }
}
