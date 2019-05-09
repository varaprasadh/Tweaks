set eng 50
set maths 60
set sci 50
set total [ expr $maths+$eng+$sci ]
set per [expr $total/3]
if { $per >60 } {
puts "first Division "
} elseif { $per >50} {
puts "Second division "
} elseif { $per > 33} {
puts "third division "
} else {
puts "Failed "
}
