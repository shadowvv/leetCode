package questions

func isZeroArray(nums []int, queries [][]int) bool {
	if len(nums) == 0 {
		return false
	}

	differ := make([]int, len(nums)+1)
	for _, query := range queries {
		differ[query[0]]++
		differ[query[1]+1]--
	}

	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += differ[i]
		if nums[i] > sum {
			return false
		}
	}
	return true
}
