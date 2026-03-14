package ood.design;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ConvertJSONtoMap {

    private Map<String, Object> map;

    @Test
    public void parse(){
        String test = "K1:V1\n"+
                "K2:V2\n"+
                "K3:\n"+
                "  K31:V31\n"+
                "  K32:\n"+
                "    K321:V321\n"+
                "     K322:V322\n"+
                "    K333:V333\n"+
                "K4:\n"+
                "  K41:V41\n"+
                "  K42:V42";

        myImpl(test);

    }

    void jsonToMap(String input){
        Map<String, Object> root = new HashMap<>();
        Stack<LevelNode> stack = new Stack<>();
        stack.push(new LevelNode(0, root));

        for(String line : input.split("\n")) {
            int level = line.lastIndexOf(" ") + 2;
            while(stack.peek().level >= level){
                stack.pop();
            }
            var parts = line.trim().split(":");
            if(parts.length < 2){
                // new parent
                var newParent = new HashMap<String, Object>();
                stack.peek().map.put(parts[0], newParent);
                stack.push(new LevelNode(level, newParent));
            } else{
                stack.peek().map.put(parts[0], parts[1]);
            }
        }

        this.map = root;
        System.out.println(map);
    }

    private void myImpl(String input){
        Map<String,Object> root = new HashMap<>();
        Stack<LevelNode> stack = new Stack<>();
        stack.push(new LevelNode(0,root));

        for(String line : input.split("\n")){
            int level = line.lastIndexOf(" ") + 2;

            while(stack.peek().level >= level)
                stack.pop();

            String[] lines = line.split(":");

            if(lines.length < 2){
                var child = new HashMap<String,Object>();
                stack.peek().map.put(lines[0].strip(),child);
                stack.push(new LevelNode(level,child));
            } else stack.peek().map.put(lines[0].strip(),lines[1]);
        }
        System.out.println(root);
    }

    public Object get(String key){
        Object value = this.map.get(key);
        if(value instanceof Map){
            return value;
        } else{
            return null;
        }
    }

    private static class LevelNode {

        int level;
        Map<String, Object> map;

        public LevelNode(int level, Map<String, Object> map){
            this.level = level;
            this.map = map;
        }
    }
}
