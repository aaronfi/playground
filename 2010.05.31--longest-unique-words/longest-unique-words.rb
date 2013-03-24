#!/usr/bin/ruby

# Author:  aaronfi@, 2010.05.31
# Coding kata:  "given a whitespace-delimited String of words, return 
# the list of the top 50% of longest unique words"

require "pp"
require "test/unit"

def longestUniqueWords(str)
  arr = str.split.uniq.sort { |a,b| a.length == b.length ? a <=> b : b.length - a.length }
  arr[0, arr.size/2]
end

class MyTest < Test::Unit::TestCase
  def test_longestUniqueWords
    
    assert_equal ["abc"],     longestUniqueWords("abc de");
    assert_equal ["abc"],     longestUniqueWords("abc de de de de de de");
    assert_equal ["a", "b"],  longestUniqueWords("a b c d");
    assert_equal ["a", "b"],  longestUniqueWords("a b c d");
    assert_equal ["a"],       longestUniqueWords("a b c");
    assert_equal [],          longestUniqueWords("");
    assert_equal ["xy", "e"], longestUniqueWords("e f f f f g g e e xy"); 
  end
end
