sss = gets.split.map(&:to_i)
list = Array.new(sss.sum+1, 0)
(1..sss[0]).each do |i|
  (1..sss[1]).each do |j|
    (1..sss[2]).each do |k|
      list[i+j+k] += 1
    end
  end
end
puts list.index(list.max)