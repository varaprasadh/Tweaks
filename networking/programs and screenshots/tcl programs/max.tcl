puts "enter the elements:"
set n [gets stdin]
set max 0
for { set i 0 } { $i < $n} { incr i } {
set a($i) [gets stdin]
}
for { set i 0 } { $i < $n } { incr i} {
if { $a($i) > $max } {
set max $a($i)
}
}
puts "max value is:$max"
