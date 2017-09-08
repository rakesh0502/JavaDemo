import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
	   	 ArrayList<String> strList = new ArrayList<>(5);

	   	 strList.add("Amit");
	   	 strList.add("Ajay");
	   	 strList.add("Ramesh");
	   	 strList.add("Jigar");
	   	 strList.add("Sanjay");

	   	 ListPrint listPrint = ((String msg, List list) -> {
	   		 System.out.print(msg);
	   		 System.out.print(list + "\n");
	   	 });
	   	 listPrint.print("ArrayList is ", strList);
	   	 String[] str = strList.toArray(new String[strList.size()]);

	   	 ObjectArrayPrint objectArrayPrint = ((Object[] objArray) -> {
	   		 for (Object obj : objArray) {
	   			 System.out.print(obj + " ");
	   		 }
	   		 System.out.println();
	   	 });

	   	 System.out.println("Array before sorting ");
	   	 objectArrayPrint.print(str);
	   	 Arrays.sort(str, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
	   	 System.out.println("Array after length sorting ");
	   	 objectArrayPrint.print(str);

	   	 System.out.println("\nStrings with length 6 are ");
	   	 strList.stream().filter(string -> string.length() == 6).forEach(System.out::print);

	   	 long count = strList.stream().filter(string -> string.length() == 4).count();
	   	 System.out.println("\nNo of strings with length 4 is " + count);

	   	 List<String> sortedList;

	   	 sortedList = strList.stream().sorted((str1, str2) -> Integer.compare(str1.length(), str2.length()))
	   			 .collect(Collectors.toList());

	   	 listPrint.print("Sorted list using sorted method which takes a comparator and collected using collectors ",
	   			 sortedList);

	   	 BiConsumer<Integer, Integer> biConsumer = (i, j) -> {
	   		 for (; i < j; i++) {
	   			 System.out.print(i + " ");
	   		 }
	   		 System.out.println();
	   	 };

	   	 Thread t1 = new Thread(() -> {
	   		 biConsumer.accept(0, 5);
	   	 });
	   	 Thread t2 = new Thread(() -> {
	   		 biConsumer.accept(10, 15);
	   	 });
	   	 
	   	 System.out.println("Threads using biConsumer");
	   	 
	   	 t1.start();
	   	 t2.start();

	   	 System.out.println("End of demo");
	}

}

interface ObjectArrayPrint {
    public void print(Object[] objArray);
}

interface ListPrint {
    public void print(String msg, @SuppressWarnings("rawtypes") List list);
}
