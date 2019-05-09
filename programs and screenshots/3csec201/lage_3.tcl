#!/usr/bin/tclsh
puts "give 3 numbers"
set data [gets stdin]
scan $data "%d%d%d" a b c

 if  { $a > $b } {
  puts $a
  }  elseif  {  $b>$c }  {
    puts $b
  } else {
     puts $c
  }
