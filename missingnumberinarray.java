class MissingNumberInArray {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; // Considering one number is missing
        int totalSum = n * (n + 1) / 2; // Sum of numbers from 1 to n
        
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num; // Calculating sum of all elements in the array
        }
        
        // The difference between totalSum and arraySum will be the missing number
        return totalSum - arraySum;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6}; // Example array with one missing number
        int missingNumber = findMissingNumber(array);
        System.out.println("The missing number is: " + missingNumber);
    }
}
