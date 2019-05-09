set n [gets stdin]
for { set i 0 } { $i < $n} { incr i } {
set b($i) [gets stdin]
}
for { set i 0 } { $i < $n-1} { incr i } {
for { set j [expr $i+1] } { $j < $n} { incr j } {
if { $b($j) < $b($i) } { 
set temp $b($j)
set b($j) $b($i)
set b($i) $temp
}
}
}
puts "Sorted array :"
for { set i 0 } { $i < $n } { incr i } {
puts "value : $b($i)"
}
