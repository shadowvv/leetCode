package main

import (
	"fmt"
	"leetCode/questions"
)

func main() {
	// Example usage
	nums := []int{2, 0, 2}
	queries := [][]int{{0, 2}, {0, 2}, {1, 1}}
	result := questions.MaxRemoval(nums, queries)
	// Print the result
	fmt.Println(result)
}
