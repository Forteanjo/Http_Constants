package sco.carlukesoftware.httpconstants.sorts

/**
 * Sorts a list of items using the quicksort algorithm.
 *
 * Quicksort is a divide-and-conquer algorithm that works by selecting a 'pivot' element from the list
 * and partitioning the other elements into two sub-lists, according to whether they are less than or
 * greater than the pivot. The sub-lists are then sorted recursively.
 *
 * This implementation uses the middle element as the pivot.
 *
 * @param items The list of items to be sorted. The items must implement the Comparable interface.
 * @return A new list containing the sorted elements. The original list is not modified.
 *
 * @param T the type of the items in the list, must be Comparable.
 * @throws IllegalArgumentException if the input List is null.
 * @sample
 *  val unsortedList = listOf(5, 2, 9, 1, 5, 6)
 *  val sortedList = quickSort(unsortedList)
 *  println(sortedList) // Output: [1, 2, 5, 5, 6, 9]
 */
fun <T: Comparable<T>> quickSort(
    items: List<T>
): List<T> {
    if (items.size < 2) {
        return items
    }

    val pivot = items[items.size / 2]
    val smaller = items.filter { item ->
        item < pivot
    }

    val bigger = items.filter { item ->
        item > pivot
    }

    val equal = items.filter { item ->
        item == pivot
    }

    return quickSort(smaller) + equal + quickSort(bigger)
}

/**
 * Sorts a list of items using the quicksort algorithm.
 *
 * This implementation of quicksort uses the middle element as the pivot.
 * It recursively sorts the sublists of elements smaller and larger than the pivot,
 * and then concatenates the sorted sublists with the elements equal to the pivot.
 *
 * @param items The list of items to be sorted. The items must be comparable.
 * @return A new list containing the sorted items.
 *
 * @param T The type of the elements in the list. Must be comparable.
 * @throws IllegalArgumentException if the input list is null.
 *
 * @sample
 * ```kotlin
 * val unsortedList = listOf(5, 2, 8, 1, 9, 4)
 * val sortedList = quickSort2(unsortedList)
 * println(sortedList) // Output: [1, 2, 4, 5, 8, 9]
 * ```
 */
fun <T : Comparable<T>> quickSort2(
    items: List<T>
): List<T> {
    if (items.size < 2) {
        return items // Base case: already sorted
    }

    val pivot = items[items.size / 2] // Choose the middle element as the pivot
    val (smaller, equal, bigger) = items.partitionByPivot(pivot)

    return quickSort(smaller) + equal + quickSort(bigger)
}

/**
 * Partitions a list of comparable elements into three sublists based on a pivot element.
 *
 * This function iterates through the list and compares each element to the provided pivot.
 * It then places each element into one of three lists:
 *   - `smaller`: Contains elements that are strictly less than the pivot.
 *   - `equal`: Contains elements that are equal to the pivot.
 *   - `bigger`: Contains elements that are strictly greater than the pivot.
 *
 * @param pivot The pivot element used for partitioning.
 * @return A Triple containing three lists: `smaller`, `equal`, and `bigger`, in that order.
 *         - `first`: The list of elements smaller than the pivot.
 *         - `second`: The list of elements equal to the pivot.
 *         - `third`: The list of elements bigger than the pivot.
 * @throws ClassCastException if the elements in the list are not comparable to each other or to the pivot.
 *
 * @sample
 * val list = listOf(5, 2, 8, 5, 1, 9, 5, 3)
 * val pivot = 5
 * val (smaller, equal, bigger) = list.partitionByPivot(pivot)
 * // smaller: [2, 1, 3]
 * // equal: [5, 5, 5]
 * // bigger: [8, 9]
 */// Extension function to partition the list based on the pivot
private fun <T : Comparable<T>> List<T>.partitionByPivot
            (pivot: T
): Triple<List<T>, List<T>, List<T>> {
    val smaller = mutableListOf<T>()
    val equal = mutableListOf<T>()
    val bigger = mutableListOf<T>()

    for (item in this) {
        when {
            item < pivot -> smaller.add(item)
            item > pivot -> bigger.add(item)
            else -> equal.add(item)
        }
    }

    return Triple(smaller, equal, bigger)
}


private fun <T : Comparable<T>> quickSortInPlace(
    items: MutableList<T>,
    low: Int = 0,
    high: Int = items.size - 1
) {
    if (low < high) {
        val pivotIndex = partitionInPlace(
            items = items,
            low = low,
            high = high
        )

        quickSortInPlace(
            items = items,
            low = low,
            high = pivotIndex - 1
        )

        quickSortInPlace(
            items = items,
            low = pivotIndex + 1,
            high = high
        )
    }
}

private fun <T : Comparable<T>> partitionInPlace(
    items: MutableList<T>,
    low: Int,
    high: Int
): Int {
    // ... (Implementation for in-place partitioning using swapping) ...
    // This is more complex and involves swapping elements within the list
    // until the pivot is in its correct sorted position.
    // Returns the final index of the pivot.
    return 0 // Placeholder
}
