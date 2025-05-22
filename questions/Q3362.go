package questions

import (
	"container/heap"
	"sort"
)

func MaxRemoval(nums []int, queries [][]int) int {
	if len(nums) == 0 {
		return -1
	}

	sort.Slice(queries, func(i, j int) bool {
		return queries[i][0] < queries[j][0]
	})
	// Initialize a max heap
	pd := &PriorityQueue{}
	heap.Init(pd)

	currentValue := 0
	differ := make([]int, len(nums)+1)
	queryIndex := 0
	for i := 0; i < len(nums); i++ {
		currentValue += differ[i]
		for queryIndex < len(queries) && queries[queryIndex][0] == i {
			heap.Push(pd, queries[queryIndex][1])
			queryIndex++
		}
		for pd.Len() > 0 && pd.Peek().(int) >= i && currentValue < nums[i] {
			right := heap.Pop(pd)
			differ[right.(int)+1]--
			currentValue++
		}
		if currentValue < nums[i] {
			return -1
		}
	}

	return pd.Len()
}

type PriorityQueue struct {
	values []int
}

// implement heap.Interface
func (pq *PriorityQueue) Push(x interface{}) {
	pq.values = append(pq.values, x.(int))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := pq.values
	n := len(old)
	x := old[n-1]
	pq.values = old[0 : n-1]
	return x
}

func (pq *PriorityQueue) Peek() interface{} {
	if len(pq.values) == 0 {
		return nil
	}
	return pq.values[0]
}

func (pq *PriorityQueue) Less(i, j int) bool {
	return pq.values[i] < pq.values[j]
}

func (pq *PriorityQueue) Swap(i, j int) {
	pq.values[i], pq.values[j] = pq.values[j], pq.values[i]
}

func (pq *PriorityQueue) Len() int {
	return len(pq.values)
}
