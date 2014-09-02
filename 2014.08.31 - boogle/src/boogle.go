package main

import (
    "fmt"
    "os"
    "log"
    "bufio"
    "sort"
)

// poor man's Trie, for use in our dictionary lookups

type Node struct {
    isWord bool
    children map[rune]Node
}
func (n Node) Add(word string) {
    curr := n
    for i, c := range word {
        _, found := curr.children[c]

        if ! found {
            isWordEnd := i == len(word) - 1
            curr.children[c] = Node{ isWordEnd, make(map[rune]Node) } 
        } 
        curr = curr.children[c]

    }
}
func (n Node) IsWord(word string) bool {
    curr := n
    for _, c := range word {
        _, found := curr.children[c]

        if found {
            curr = curr.children[c]
        } else {
            return false
        }
    }  

    return curr.isWord
}
func (n Node) IsWordPrefix(prefix string) bool {
    curr := n
    for _, c := range prefix {
        _, found := curr.children[c]

        if found {
            curr = curr.children[c]
        } else {
            return false
        }  
    }
 
    return len(curr.children) > 0
}

var dict = func() Node {
    n := Node{ false, make(map[rune]Node) }

    file, err := os.Open("words.txt")
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        n.Add(scanner.Text())
    }
 
    if err := scanner.Err(); err != nil {
        log.Fatal(err)
    }
 
    return n 
}()

func IsLegalWord(word string) bool {
    return len(word) >= 3 && dict.IsWord(word)
}

func IsLegalWordPrefix(prefix string) bool {
    return dict.IsWordPrefix(prefix)
}

//   0  1  2  3
//   4  5  6  7
//   8  9 10 11
//  12 13 14 15

var board = [][]int {  // denotes adjacent neighbors from a given cell number
    []int { 1, 4, 5 },
    []int { 0, 2, 4, 5, 6 },
    []int { 1, 3, 5, 6, 7 },
    []int { 2, 6, 7 },
    []int { 0, 1, 5, 8, 9 },
    []int { 0, 1, 2, 4, 6, 8, 9, 10 },
    []int { 1, 2, 3, 5, 7, 9, 10, 11 },
    []int { 2, 3, 6, 10, 11 },
    []int { 4, 5, 9, 12, 13 },
    []int { 4, 5, 6, 8, 10, 12, 13, 14 },
    []int { 5, 6, 7, 9, 11, 13, 14, 15 },
    []int { 6, 7, 10, 14, 15 },
    []int { 8, 9, 13 },
    []int { 8, 9, 10, 12, 14 },
    []int { 9, 10, 11, 13, 15 },
    []int { 10, 11, 14 },
}

func printBoard(visited [16]bool) {
    if (visited[0])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[1])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[2])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[3])  { fmt.Println("X") } else { fmt.Println(".") }

    if (visited[4])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[5])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[6])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[7])  { fmt.Println("X") } else { fmt.Println(".") }

    if (visited[8])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[9])  { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[10]) { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[11]) { fmt.Println("X") } else { fmt.Println(".") }

    if (visited[12]) { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[13]) { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[14]) { fmt.Print("X") } else { fmt.Print(".") }
    if (visited[15]) { fmt.Println("X") } else { fmt.Println(".") }
    
    fmt.Println()
}


func _process(letters string, curr int, visited [16]bool, prefix string, results map[string]bool) {
    if ! IsLegalWordPrefix(prefix) {
        return
    }
 
    if IsLegalWord(prefix) {
        results[prefix] = true
    }   

    visited[curr] = true
 
   // printBoard(visited)

   // TODO (1) add the prefix optimization, (2) double check that you need to set visited[curr] = true, (3) apply go's deferment for speed up -- measure said speed up
    
    for _, i := range board[curr] {
        if ! visited[i] { 
            //visited[i] = true
            _process(letters, i, visited, prefix + string(letters[i]), results)
        }
    } 
} 

func process(letters string) []string {
    results := make(map[string]bool)

    for i, _ := range board {
        _process(letters, i, [16]bool{}, string(letters[i]), results)
    }
 
    var keys []string
    for k := range results {
        keys = append(keys, k)
    }
    sort.Strings(keys)

    return keys
}

func main() {
/*
    fmt.Println(process("cat............."))
    fmt.Println(process(".cat............"))
    fmt.Println(process("..cat..........."))
    fmt.Println(process("...cat.........."))
*/
fmt.Println(
process("dghiklpsyeuteorn"))
//    fmt.Println(process("....cat........."))
/*    fmt.Println(process(".....cat........"))
    fmt.Println(process("......cat......."))
    fmt.Println(process(".......cat......"))
    fmt.Println(process("........cat....."))
    fmt.Println(process(".........cat...."))
    fmt.Println(process("..........cat..."))
    fmt.Println(process("...........cat.."))
    fmt.Println(process("............cat."))
    fmt.Println(process(".............cat"))
*/
}
