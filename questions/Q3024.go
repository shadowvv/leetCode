package questions

func TriangleType(nums []int) string {
	if len(nums) != 3 {
		return "none"
	}
	a, b, c := nums[0], nums[1], nums[2]
	if a+b > c && a+c > b && b+c > a {
		if a == b && b == c {
			return "equilateral "
		}
		if a == b || b == c || a == c {
			return "isosceles"
		}
		return "scalene"
	}
	return "none"
}
