package main

import (
	"leetCode/questions"
)

func main() {
	// Example usage
	nums := []int{3, 4, 5}
	result := questions.TriangleType(nums)
	println(result) // Output: scalene
	nums2 := []int{3, 3, 3}
	result2 := questions.TriangleType(nums2)
	println(result2) // Output: equilateral
}
