package ood.design;

import java.util.*;

public class FamilyTree {

    private Person root;
    private Map<Integer,Person> parentMap;


    public FamilyTree(Person r){
        this.root = r;
        this.parentMap = new TreeMap<>();
        buildParentMap(this.root,this.parentMap);

    }

    private void buildParentMap(Person parent,Map<Integer,Person> map){
        if(parent == null || parent.children.isEmpty())
            return;

        for(Person child : parent.children){
            map.put(child.id,parent);
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

    public Person getParent(Person person){
        return parentMap.get(person.id);
    }

    public Person getGreatParent(Person person){
        Person parent = parentMap.get(person.id);
        if(parent == null)
            return new Person(-1,"nobody");
        Person gp =  parentMap.get(parent.id);
        if(gp == null)
            return new Person(-1,"nobody");
        return gp;
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

        public Person(int id,String n){
            this.id = id;
            this.name= n;
            children = new ArrayList<>();
        }

        @Override
        public String toString(){
            return "Person{"+
                    "name='"+name+'\''+
                    ", id="+id+
                    '}';
        }
    }

    public Map<String,List<Person>> getRelationships(Person person){
        Map<String,List<Person>> result = new HashMap<>();
        result.put("parent", List.of(getParent(person)));
        result.put("greand parent", List.of(getGreatParent(person)));
        result.put("child", getChildren(person));
        return result;
    }

    public static void main(String[] args){
        Person root = new Person(0,"a");
        Person p1 = new Person(1,"b");
        Person p2 = new Person(2,"c");
        Person p3 = new Person(3,"d");

        Person p4 = new Person(4,"e");
        Person p5 = new Person(5,"f");
        Person p6 = new Person(6,"g");

        root.children.add(p1);
        root.children.add(p2);
        root.children.add(p3);

        p1.children.add(p4);
        p2.children.add(p5);
        p3.children.add(p6);

        FamilyTree tree = new FamilyTree(root);

        System.out.println(
                tree.getRelationships(p3)
        );
    }
}
