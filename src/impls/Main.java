package impls;

public class Main {
    public static void main(String[] args) {
//        int[][] nums = new int[3][3];
//        nums[0][0] = 10;
//        nums[0][1] = 20;
//        nums[0][2] = 30;
//        nums[1][0] = 40;
//        nums[1][1] = 50;
//        nums[1][2] = 60;
//        nums[2][0] = 70;
//        nums[2][1] = 80;
//        nums[2][2] = 90;
//
//        for (int i = 0; i < nums[0].length; i++) {
//            for (int j = 0; j < nums[0].length; j++) {
//                System.out.print("\t"+nums[i][j]);
//            }
//            System.out.println();
//
//        }

        DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>();
//        System.out.println("Size: "+ dynamicArray.getSize());
        dynamicArray.printArr();
//        System.out.println("Size: "+ dynamicArray.getSize());
        dynamicArray.add(10);
        dynamicArray.printArr();
        dynamicArray.add(11);
        dynamicArray.printArr();
        dynamicArray.add(12);
        dynamicArray.printArr();
        dynamicArray.add(14);
        dynamicArray.printArr();
        dynamicArray.remove(14);
        dynamicArray.printArr();

    }
}
