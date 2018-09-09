import lists.Cat;
import lists.DoubleLinkedList;
import lists.DoubleLinkedListIterator;

public class Main {
    public static void main(String[] args) {
//        checkBrace("()(()[][{}]){[");
//        System.out.println(toMirrorString("А роза упала на лапу азора"));

        DoubleLinkedList list = new DoubleLinkedList();
        list.insert(new Cat(12, "Murzik"));
        list.insert(new Cat(13, "Barsik"));
        list.insert(new Cat(14, "Kisik"));
        list.insert(new Cat(15, "Krisik"));
        list.insert(new Cat(16, "Pisik"));

        DoubleLinkedListIterator iterator = list.getIterator();

        System.out.println(iterator.get());
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        iterator.reset();

        System.out.println(iterator.get());
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public static void checkBrace(String string){
        boolean closeOk = true;
        Stack round = new Stack(10);
        Stack angle = new Stack(10);
        Stack figure = new Stack(10);
        Stack square = new Stack(10);

        for (int i = 0; i < string.length(); i++) {
            try {
                switch (string.charAt(i)){
                    case '(':
                        round.push(1);
                        break;
                    case ')':
                        round.pop();
                        break;
                    case '<':
                        angle.push(1);
                        break;
                    case '>':
                        angle.pop();
                        break;
                    case '{':
                        figure.push(1);
                        break;
                    case '}':
                        figure.pop();
                        break;
                    case '[':
                        square.push(1);
                        break;
                    case ']':
                        square.pop();
                        break;
                    default:
                        throw new RuntimeException("Unknown char");
                }
            } catch (RuntimeException e){
                String str = e.getMessage();
                if (str.equals("Stack is Empty")){
                    System.out.println(string.charAt(i) + " too many");
                    closeOk = false;
                }
                    if (str.equals("Unknown char")){
                    System.out.println(str);
                }
            }
        }
        if (!round.isEmpty())
            System.out.println("( too many ");
        if (!angle.isEmpty())
            System.out.println("< too many");
        if (!figure.isEmpty())
            System.out.println("{ too many");
        if (!square.isEmpty())
            System.out.println("[ too many");

        if (closeOk && round.isEmpty() && angle.isEmpty() && figure.isEmpty() && square.isEmpty()){
            System.out.println("Ok!");
        }
    }

    public static String toMirrorString(String string){
        Stack stack = new Stack(string.length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            stack.push((int) ch);
        }
        for (int i = 0; i < string.length(); i++) {
            int a = stack.pop();
            char[] ch = Character.toChars(a);
            result.append(ch[0]);
        }
        return result.toString();
    }
}
