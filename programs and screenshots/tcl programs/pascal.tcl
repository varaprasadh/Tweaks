puts "enter no.of rows:"
set a [gets stdin]
for {set i 0} {$i<$a} { incr i} {
for {set s 0} {$s<=$a-$i} { incr s} {
puts -nonewline " "
}
for {set j 0} {$j<=$i} {incr j} {
if {$j==0 || $i==0} {
set b 1
} else {
set b [expr $b*($i-$j+1)/$j]
}
puts -nonewline "$b "
}
puts ""
}
