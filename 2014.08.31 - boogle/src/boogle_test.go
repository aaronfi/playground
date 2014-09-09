package main

import (
     "reflect"
     "testing"
)

func TestBoogle(t *testing.T) {
    var assert = func(t *testing.T, expected []string, actual []string) {
        if ! (len(expected) == len(actual) || reflect.DeepEqual(expected, actual)) {
            t.Error("mismatch between expected and actual")
        } 
    }

    expected := []string {
       "eel", "eer", "eld", "eye", "eyer", "glee", "glut", "hip", "hipe", "his", "hist",
       "ist", "kep", "kern", "lee", "leu", "lust", "lut", "lye", "nul", "nut", "oer", "ort",
       "our", "oust", "out", "pee", "per", "pern", "pert", "phi", "pist", "plus", "ply",
       "pun", "pur", "put", "ree", "rel", "rep", "roe", "run", "rush", "rust", "rut", "shi",
       "ship", "sip", "sipe", "spun", "spur", "spurn", "sput", "stre", "stree", "strey",
       "stroy", "sue", "sulk", "sulky", "sun", "sur", "tree", "trek", "tsun", "tue", "tun",
       "tur", "turn", "ule", "urn", "ush", "ust", "yee", "yeo", "yer", "yor", "you", "your",
    }

    assert(t, expected, BoogleGame.Solve("dghiklpsyeuteorn"))

    assert(t, []string { "cat" }, BoogleGame.Solve("cat............."))
    assert(t, []string { "cat" }, BoogleGame.Solve(".cat............"))
    assert(t, []string {       }, BoogleGame.Solve("..cat..........."))
    assert(t, []string {       }, BoogleGame.Solve("...cat.........."))
    assert(t, []string { "cat" }, BoogleGame.Solve("....cat........."))
    assert(t, []string { "cat" }, BoogleGame.Solve(".....cat........"))
    assert(t, []string {       }, BoogleGame.Solve("......cat......."))
    assert(t, []string {       }, BoogleGame.Solve(".......cat......"))
    assert(t, []string { "cat" }, BoogleGame.Solve("........cat....."))
    assert(t, []string { "cat" }, BoogleGame.Solve(".........cat...."))
    assert(t, []string {       }, BoogleGame.Solve("..........cat..."))
    assert(t, []string {       }, BoogleGame.Solve("...........cat.."))
    assert(t, []string { "cat" }, BoogleGame.Solve("............cat."))
    assert(t, []string { "cat" }, BoogleGame.Solve(".............cat"))

    assert(t, []string {}, BoogleGame.Solve("malformed board wrong size"))
}
