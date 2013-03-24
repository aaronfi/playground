#!/usr/bin/ruby

# Author:  aaronfi@, 2011.05.12
# Coding kata:  implement the logic for reversing a doubly-linked list

require "pp"
require "test/unit"

class List
  attr_reader :head, :tail, :length

  Node = Struct.new(:value, :prev, :next)

  ####################################

  def append(e)
    n = Node.new(e)
    
    if @head.nil?
      @head = @tail = n
    else 
      @tail.next = n
      n.prev = @tail
      @tail = n
    end

    @length = @length + 1

    self
  end

  def initialize(*enum)
    @head = @tail = nil
    @length = 0
    enum.each { |e| append e }
  end

  ####################################

  def ==(otherList)
    return @head.nil? if otherList.nil?
    return false if @length != otherList.length
    
    i = @head
    j = otherList.head
    while not i.nil?
      return false if i.value != j.value
      i = i.next
      j = j.next
    end

    true
  end

  ####################################
  # the actual reversal logic

  def reverse() 
    @tail = @head
    i = @head
    
    while not i.nil? do
      i.next, i.prev = i.prev, i.next  # swap  
      @head = i if i.prev.nil?
      i = i.prev
    end

    self
  end

  ####################################
  # not needed, but fun to write.

  def each
    i = @head
    while not i.nil? 
      yield i.value
      i = i.next
    end
  end

  def to_s
    str = []
    each { |n| str.push n }
    "[#{str.join ","}]"
  end

end

class MyTest < Test::Unit::TestCase
  def test_reversal
    assert_equal List.new(1,2,3), List.new(3,2,1).reverse
    assert_equal List.new(1),     List.new(1).reverse
    assert_equal List.new(),      List.new().reverse

    assert_not_equal List.new(1,2,3), List.new(1,2,3).reverse

    list = List.new(1,2,3)
    puts
    puts "#{list} reversed is #{list.reverse}"
    puts "#{list} reversed is #{list.reverse}"

    list = List.new(1)
    puts "#{list} reversed is #{list.reverse}"

    list = List.new()
    puts "#{list} reversed is #{list.reverse}"
    
    puts
  end
end
