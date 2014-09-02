package main

import (
    "bufio"
    "fmt"
    "log"
    "os"
    "sort"
    "sync"
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
func (n Node) IsWord(candidate string) bool {
    curr := n
    for _, c := range candidate {
        _, found := curr.children[c]

        if found {
            curr = curr.children[c]
        } else {
            return false
        }
    }  

    return curr.isWord
}
func (n Node) IsWordPrefix(candidate string) bool {
    curr := n
    for _, c := range candidate {
        _, found := curr.children[c]

        if found {
            curr = curr.children[c]
        } else {
            return false
        }  
    }
 
    return len(curr.children) > 0
}

type Boogle struct {
    wg sync.WaitGroup    

    dict Node
    board [][]int
    words map[string]bool
    
}
func (b Boogle) IsLegalWord(word string) bool {
    return len(word) >= 3 && b.dict.IsWord(word)
}
func (b Boogle) IsLegalWordPrefix(prefix string) bool {
    return b.dict.IsWordPrefix(prefix)
}
func (b Boogle) _solve(letters string, curr int, visited [16]bool, candidate string, wg *sync.WaitGroup) {
    defer wg.Done()

    if ! b.IsLegalWordPrefix(candidate) {
        return
    }
 
    if b.IsLegalWord(candidate) {
        b.words[candidate] = true
    }   

    visited[curr] = true
 
    for _, i := range b.board[curr] {
        if ! visited[i] { 
            visited[i] = true

            wg.Add(1)
            go b._solve(letters, i, visited, candidate + string(letters[i]), wg)
        }
    }
} 
func (b Boogle) Solve(letters string) []string {
    b.words = make(map[string]bool)

    var wg sync.WaitGroup

    for i, _ := range b.board {
        wg.Add(1)
        go b._solve(letters, i, [16]bool{}, string(letters[i]), &wg)
    }
    wg.Wait()
 
    // sort our found words
    var keys []string
    for k := range b.words {
        keys = append(keys, k)
    }
    sort.Strings(keys)

    return keys
}

var BoogleGame = func() *Boogle {
    boogle := Boogle{}

    //   0  1  2  3
    //   4  5  6  7
    //   8  9 10 11
    //  12 13 14 15
    boogle.board = [][]int {  // denotes adjacent neighbors from a given cell number
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

    boogle.dict = func() Node {
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

    return &boogle
}()

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

func main() {

    fmt.Println(BoogleGame.Solve("cat............."))
    fmt.Println(BoogleGame.Solve(".cat............"))
    fmt.Println(BoogleGame.Solve("..cat..........."))
    fmt.Println(BoogleGame.Solve("...cat.........."))
    fmt.Println(BoogleGame.Solve("....cat........."))
    fmt.Println(BoogleGame.Solve(".....cat........"))
    fmt.Println(BoogleGame.Solve("......cat......."))
    fmt.Println(BoogleGame.Solve(".......cat......"))
    fmt.Println(BoogleGame.Solve("........cat....."))
    fmt.Println(BoogleGame.Solve(".........cat...."))
    fmt.Println(BoogleGame.Solve("..........cat..."))
    fmt.Println(BoogleGame.Solve("...........cat.."))
    fmt.Println(BoogleGame.Solve("............cat."))
    fmt.Println(BoogleGame.Solve(".............cat"))

}
