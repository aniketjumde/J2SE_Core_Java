public class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Developer");
        System.out.println("After append: " + sb);

        sb.insert(4, " FullStack");
        System.out.println("After insert: " + sb);

        sb.delete(0, 4);
        System.out.println("After delete: " + sb);

        sb.replace(0, 9, "Backend");
        System.out.println("After replace: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}

