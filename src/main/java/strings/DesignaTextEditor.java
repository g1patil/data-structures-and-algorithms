package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 2296. Design a Text Editor
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DesignaTextEditor {

    StringBuilder sb = new StringBuilder();
    int cursor = 0;

    public DesignaTextEditor() {
    }

    public void addText(String text) {
        sb.insert(cursor,text);
        cursor+=text.length();
    }

    public int deleteText(int k) {
        int rightBound = Math.max(cursor - k ,0 );
        int oldLength = sb.length();
        sb.delete( rightBound , cursor );
        cursor = rightBound;
        return Math.abs( sb.length() - oldLength);
    }

    public String cursorLeft(int k) {
        int bound = Math.max(cursor - k ,0 );
        int start = Math.max( bound- 10 , 0 );
        cursor = bound;
        return sb.substring( start , bound);
    }

    public String cursorRight(int k) {
        int bound = Math.min( sb.length() ,  cursor + k );
        int start = Math.max( bound - 10 , 0 );
        cursor = bound;
        return sb.substring( start , bound);
    }

    public static void main(String[] args){
        DesignaTextEditor textEditor = new DesignaTextEditor();

        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));

        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));

        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));

        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorRight(6));
    }

}
