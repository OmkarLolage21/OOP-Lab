package FinalOOPLab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayIntersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 1};
        int[] nums2 = {3, 2};
        int[] result = intersection(nums1, nums2);
        System.out.print("Intersection: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] result2 = intersection(nums3, nums4);
        System.out.print("Intersection: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

