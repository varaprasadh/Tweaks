puts "give something"

set data [gets stdin]
scan $data "%d%d" x y

puts [expr $x+$y]
