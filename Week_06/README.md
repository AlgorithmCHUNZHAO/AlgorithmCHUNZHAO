## 学习笔记


### 布隆过滤器的原理和实现
1.字处理软件上,需要检查一个英语单词是否拼写正确

2.在FBI中,一个嫌疑人的名字是否已经在嫌疑名单上

3 yahoo,gmail等邮箱垃圾邮件过滤功能

#### 这几个例子有一个共同点就是: **如何判断一个元素是否在一个集合中**
####
```

# Python 3 program to build Bloom Filter
# Install mmh3 and bitarray 3rd party module first
# pip install mmh3
# pip install bitarray
import math
import mmh3
from bitarray import bitarray


class BloomFilter(object):

	'''
	Class for Bloom filter, using murmur3 hash function
	'''

	def __init__(self, items_count, fp_prob):
		'''
		items_count : int
			Number of items expected to be stored in bloom filter
		fp_prob : float
			False Positive probability in decimal
		'''
		# False posible probability in decimal
		self.fp_prob = fp_prob

		# Size of bit array to use
		self.size = self.get_size(items_count, fp_prob)

		# number of hash functions to use
		self.hash_count = self.get_hash_count(self.size, items_count)

		# Bit array of given size
		self.bit_array = bitarray(self.size)

		# initialize all bits as 0
		self.bit_array.setall(0)

	def add(self, item):
		'''
		Add an item in the filter
		'''
		digests = []
		for i in range(self.hash_count):

			# create digest for given item.
			# i work as seed to mmh3.hash() function
			# With different seed, digest created is different
			digest = mmh3.hash(item, i) % self.size
			digests.append(digest)

			# set the bit True in bit_array
			self.bit_array[digest] = True

	def check(self, item):
		'''
		Check for existence of an item in filter
		'''
		for i in range(self.hash_count):
			digest = mmh3.hash(item, i) % self.size
			if self.bit_array[digest] == False:

				# if any of bit is False then,its not present
				# in filter
				# else there is probability that it exist
				return False
		return True

	@classmethod
	def get_size(self, n, p):
		'''
		Return the size of bit array(m) to used using
		following formula
		m = -(n * lg(p)) / (lg(2)^2)
		n : int
			number of items expected to be stored in filter
		p : float
			False Positive probability in decimal
		'''
		m = -(n * math.log(p))/(math.log(2)**2)
		return int(m)

	@classmethod
	def get_hash_count(self, m, n):
		'''
		Return the hash function(k) to be used using
		following formula
		k = (m/n) * lg(2)

		m : int
			size of bit array
		n : int
			number of items expected to be stored in filter
		'''
		k = (m/n) * math.log(2)
		return int(k)

```
### Boolm Test

```
from bloomfilter import BloomFilter
from random import shuffle

n = 20 #no of items to add
p = 0.05 #false positive probability

bloomf = BloomFilter(n,p)
print("Size of bit array:{}".format(bloomf.size))
print("False positive Probability:{}".format(bloomf.fp_prob))
print("Number of hash functions:{}".format(bloomf.hash_count))

# words to be added
word_present = ['abound','abounds','abundance','abundant','accessable',
				'bloom','blossom','bolster','bonny','bonus','bonuses',
				'coherent','cohesive','colorful','comely','comfort',
				'gems','generosity','generous','generously','genial']

# word not added
word_absent = ['bluff','cheater','hate','war','humanity',
			'racism','hurt','nuke','gloomy','facebook',
			'geeksforgeeks','twitter']

for item in word_present:
	bloomf.add(item)

shuffle(word_present)
shuffle(word_absent)

test_words = word_present[:10] + word_absent
shuffle(test_words)
for word in test_words:
	if bloomf.check(word):
		if word in word_absent:
			print("'{}' is a false positive!".format(word))
		else:
			print("'{}' is probably present!".format(word))
	else:
		print("'{}' is definitely not present!".format(word))


```
### 排序算法的总结
#### 比较类排序和非比较排序
##### 1.比较类排序:通过比较来决定元素间的相对次序,由于其时间复杂度不能突破O(nlogn),因此成为非线性类排序

##### 2.非比较类排序:不通过比较来决定元素间的相对次序,它可以突破基于比较类的时间下界,以线性时间非比较类排序

##### 1.1 交换类排序
##### 1.1.1BubbleSort
```
// Java program for implementation of Bubble Sort
class BubbleSort
{
	void bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}

	/* Prints the array */
	void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method to test above
	public static void main(String args[])
	{
		BubbleSort ob = new BubbleSort();
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
/* This code is contributed by Rajat Mishra */

```
#### 1.1.2 QuickSort
```
/* low  --> Starting index,  high  --> Ending index */
quickSort(arr[], low, high)
{
    if (low < high)
    {
        /* pi is partitioning index, arr[pi] is now
           at right place */
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}


	static void sort(int arr[], int start, int end) {
		if (start < end) {
			int pIndex = partition(arr, start, end);
			sort(arr, start, pIndex - 1);
			sort(arr, pIndex + 1, end);
		}
	}

	static int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		swap(arr, pIndex, end);
		return pIndex;
	}

	static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
```

#### 1.2插入排序
#### 1.2.1 InsertionSort

```
// Java program for implementation of Insertion Sort
class InsertionSort {
	/*Function to sort array using insertion sort*/
	void sort(int arr[])
	{
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/* Move elements of arr[0..i-1], that are
			greater than key, to one position ahead
			of their current position */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	/* A utility function to print array of size n*/
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	// Driver method
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		ob.sort(arr);

		printArray(arr);
	}
} /* This code is contributed by Rajat Mishra. */

```
#### 1.2.2  ShellSort

```
// Java implementation of ShellSort
class ShellSort
{
	/* An utility function to print array of size n*/
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/* function to sort arr using shellSort */
	int sort(int arr[])
	{
		int n = arr.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n/2; gap > 0; gap /= 2)
		{
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1)
			{
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = arr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
		return 0;
	}

	// Driver method
	public static void main(String args[])
	{
		int arr[] = {12, 34, 54, 2, 3};
		System.out.println("Array before sorting");
		printArray(arr);

		ShellSort ob = new ShellSort();
		ob.sort(arr);

		System.out.println("Array after sorting");
		printArray(arr);
	}
}
/*This code is contributed by Rajat Mishra */

```
#### 1.3  MergeSort

```
// Recursive Java Program for merge sort

import java.util.Arrays;
public class GFG
{
	public static void mergeSort(int[] array)
	{
		if(array == null)
		{
			return;
		}

		if(array.length > 1)
		{
			int mid = array.length / 2;

			// Split left part
			int[] left = new int[mid];
			for(int i = 0; i < mid; i++)
			{
				left[i] = array[i];
			}
			
			// Split right part
			int[] right = new int[array.length - mid];
			for(int i = mid; i < array.length; i++)
			{
				right[i - mid] = array[i];
			}
			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			// Merge left and right arrays
			while(i < left.length && j < right.length)
			{
				if(left[i] < right[j])
				{
					array[k] = left[i];
					i++;
				}
				else
				{
					array[k] = right[j];
					j++;
				}
				k++;
			}
			// Collect remaining elements
			while(i < left.length)
			{
				array[k] = left[i];
				i++;
				k++;
			}
			while(j < right.length)
			{
				array[k] = right[j];
				j++;
				k++;
			}
		}
	}

	// Driver program to test above functions.
	public static void main(String[] args)
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		int i=0;
		System.out.println("Given array is");

		for(i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");

		mergeSort(arr);

		System.out.println("\n");
		System.out.println("Sorted array is");

		for(i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}

// Code Contributed by Mohit Gupta_OMG

```
#### 1.1.4 Counting Sort

```
// Recursive Java Program for merge sort

import java.util.Arrays;
public class GFG
{
	public static void mergeSort(int[] array)
	{
		if(array == null)
		{
			return;
		}

		if(array.length > 1)
		{
			int mid = array.length / 2;

			// Split left part
			int[] left = new int[mid];
			for(int i = 0; i < mid; i++)
			{
				left[i] = array[i];
			}
			
			// Split right part
			int[] right = new int[array.length - mid];
			for(int i = mid; i < array.length; i++)
			{
				right[i - mid] = array[i];
			}
			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			// Merge left and right arrays
			while(i < left.length && j < right.length)
			{
				if(left[i] < right[j])
				{
					array[k] = left[i];
					i++;
				}
				else
				{
					array[k] = right[j];
					j++;
				}
				k++;
			}
			// Collect remaining elements
			while(i < left.length)
			{
				array[k] = left[i];
				i++;
				k++;
			}
			while(j < right.length)
			{
				array[k] = right[j];
				j++;
				k++;
			}
		}
	}

	// Driver program to test above functions.
	public static void main(String[] args)
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		int i=0;
		System.out.println("Given array is");

		for(i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");

		mergeSort(arr);

		System.out.println("\n");
		System.out.println("Sorted array is");

		for(i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}

// Code Contributed by Mohit Gupta_OMG

```