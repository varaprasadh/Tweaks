puts "give some n"
set buff [gets stdin]
scan $buff "%d" n
for {set i 0} {$i < $n} { incr i} {
  set num($i) =$i +100
 
}

