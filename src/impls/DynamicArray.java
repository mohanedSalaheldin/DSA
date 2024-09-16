package impls;

import java.util.Arrays;

public class DynamicArray<T> {
    Object[] arr;
    int size;


    public DynamicArray() {
        this.size = 0;
        this.arr= new Object[1];
    }

   public void add(int item){
    checkLength(size+1);
    arr[size++] = item;
    }
    public void remove(Object element){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element){
                arr[i] = null;
                for (int j = i; j < arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1]= null;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void checkLength(int newLength) {
        int oldSize = arr.length;
        if (newLength > oldSize) {
            arr = Arrays.copyOf(arr, oldSize*2);
        }
    }


    public void printArr(){
        System.out.println("________________________(ARRAY)_____________________");
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i);
//            System.out.println(arr[i]);
            System.out.print(arr[i]+ "    ");
        }
//        System.out.println("");
        System.out.println("\n________________________(ARRAY)_____________________");
    }
    @Override
    public String toString() {

        return "impls.DynamicArray{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
