package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            String str1 = list.get(i);
            String str2 = list.get(i + 1);

            if (str1.length() <= str2.length()) {
                list.remove(i);
            }

            else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            int originalSize = list.size();

            for (int i = 0; i < originalSize; i++) {
                String currentElement = list.get(i * 2);
                list.add(i * 2, currentElement);
            }
    }

    public void switchPairs(List<String> list) {
            for (int i = 0; i < list.size() - 1; i += 2) {
                String first = list.get(i);
                String second = list.get(i + 1);

                list.set(i, second);
                list.set(i + 1, first);

        }
    }

    public void removeDuplicates(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return true;
        }

        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int originalSize = queue.size();

        for (int i = 0; i < originalSize; i++) {
            int element = queue.remove();
            stack.push(element);
            queue.add(element);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < originalSize; i++) {
            int queueElement = queue.remove();
            int stackElement = stack.pop();

            if (queueElement != stackElement) {
                isPalindrome = false;
            }

            queue.add(queueElement);
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int originalSize = queue.size();
        int negativeCount = 0;

        for (int i = 0; i < originalSize; i++) {
            int element = queue.remove();
            if (element < 0) {
                stack.push(element);
                negativeCount++;
            } else {
                queue.add(element);
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        int nonNegativeCount = originalSize - negativeCount;
        for (int i = 0; i < nonNegativeCount; i++) {
            queue.add(queue.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int originalSize = queue.size();

        for (int i = 0; i < originalSize; i++) {
            int element = queue.remove();
            if (element % 2 == 0) {
                queue.add(element);
            } else {
                stack.push(element);
            }
        }

        int oddCount = stack.size();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int evenCount = originalSize - oddCount;
        for (int i = 0; i < evenCount; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < oddCount; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }

        int maxLength = 0;

        for (String str : set) {
            int currentLength = str.length();

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }

    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()) {
            return 0;
        }

        Set<Integer> set1 = new HashSet<>(list1);

        Set<Integer> commonElements = new HashSet<>();

        for (Integer num : list2) {
            if (set1.contains(num)) {
                commonElements.add(num);
            }
        }

        return commonElements.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }

        Set<String> seenValues = new HashSet<>();

        for (String value : map.values()) {
            if (seenValues.contains(value)) {
                return false;
            }
            seenValues.add(value);
        }

        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1 == null || map2 == null) {
            return new HashMap<>();
        }

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        if (map == null) {
            return new HashMap<>();
        }

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            result.put(value, key);
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer value : map.values()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        int minFrequency = Integer.MAX_VALUE;
        int rarestValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer value = entry.getKey();
            Integer frequency = entry.getValue();

            if (frequency < minFrequency) {
                minFrequency = frequency;
                rarestValue = value;
            }

            else if (frequency == minFrequency && value < rarestValue) {
                rarestValue = value;
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> occurrencesMap = new HashMap<>();

        for (Integer num : list) {
            occurrencesMap.put(num, occurrencesMap.getOrDefault(num, 0) + 1);
        }

        int maxOccurrences = 0;

        for (Integer count : occurrencesMap.values()) {
            if (count > maxOccurrences) {
                maxOccurrences = count;
            }
        }

        return maxOccurrences;
    }

}
