#!/usr/bin/ruby

# Author:  aaronfi@

require "pp"
require "test/unit"

def someMethod(param)
end

class MyTest < Test::Unit::TestCase
  def test_method
    assert_equal 1, 1
  end
end
