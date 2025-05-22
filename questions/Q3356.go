package questions

func minZeroArray(nums []int, queries [][]int) int {
	if len(nums) == 0 {
		return -1
	}

	maxIndex := 0
	currentValue := 0
	differ := make([]int, len(nums)+1)

	for i := 0; i < len(nums); i++ {
		currentValue += differ[i]
		for currentValue < nums[i] && maxIndex < len(queries) {
			left := queries[maxIndex][0]
			right := queries[maxIndex][1]
			differ[left] += queries[maxIndex][2]
			differ[right+1] -= queries[maxIndex][2]
			if left <= i && i <= right {
				currentValue += queries[maxIndex][2]
			}
			maxIndex++
		}
		if currentValue < nums[i] {
			return -1
		}
	}
	return maxIndex
}
