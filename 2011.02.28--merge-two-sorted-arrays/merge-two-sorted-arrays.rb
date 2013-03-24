#!/usr/bin/ruby

# author:  aaronfi@, 2011.02.28
# write a method that, given two already sorted arrays,
# merges them into one large, sorted array.

require "pp"
require "test/unit"

def merge(a, b)
  c = []
  ai, bi = a.length-1, b.length-1
  ci = a.length + b.length - 1

  while ai >= 0 && bi >= 0 && ci >=0
   if a[ai] >= b[bi]
      c[ci] = a[ai]
      ai -= 1
    else
      c[ci] = b[bi]
      bi -= 1
    end
    ci -= 1    
  end

  # copy over the remaining portion of the longer array
  t = (ai >= 0) ? a : b
  while ci >= 0
    c[ci] = t[ci]
    ci -= 1
  end

  c
end

class MyTest < Test::Unit::TestCase
  def test_method
    assert_equal [1,2,3,4],               merge( [1,3],     [2,4]           )
    assert_equal [1,2],                   merge( [1],       [2]             )
    assert_equal [1],                     merge( [1],       []              )
    assert_equal [1],                     merge( [],        [1]             )
    assert_equal [1,2,4,4,5,6,7,8,10,12], merge( [1,4,5,7], [2,4,6,8,10,12] )
  end
end
