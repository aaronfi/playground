#!/usr/bin/ruby

# Author:  aaronfi@ 2010.06.01
#
# write a function that returns all permutations of a given string

require "pp"
require "test/unit"

class String
  def permutations
    return [self] if size < 2
    values = []

    # For each letter in the string, remove it, then append it to each of 
    # the permutations of the remaining set.  This is cleverly exhaustive.  
    0.upto(self.length - 1) do |i|
      letters = self.split ''
      remaining = letters.delete_at i
      letters.join.permutations.each { |char| values << remaining + char }
    end

    values
  end

  def combinations
    self.permutations.uniq  # Just because I can.  It's that easy.
  end
end

class MyTest < Test::Unit::TestCase
  def test_method
    assert_equal "abc".permutations, ["abc", "acb", "bac", "bca", "cab", "cba"]
    assert_equal "ab".permutations, ["ab", "ba"]
    assert_equal "a".permutations, ["a"]
    assert_equal "".permutations, [""]
  end
end
