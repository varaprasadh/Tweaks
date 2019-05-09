set ns [new Simulator]
set nf [open out.nam w]
$ns namtrace-all $nf

proc finish { } {
 global ns nf
 $ns  flush-trace
 close $nf
 exec nam out.nam &
  exit 0
  
}
set n0 [$ns node]
set n1 [$ns node]
$n1 color red
$n0 color green
$ns duplex-link $n0 $n1 1mb 10s DropTail
$ns at 5.0 "finish"
$ns run

