#!/usr/bin/tclsh

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
#creation of nodes..
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
#linking  b/w nodes
$ns duplex-link $n0 $n1 1mb 10s DropTail
$ns duplex-link $n0 $n2 1mb 10s DropTail
$ns duplex-link $n0 $n3 1mb 10s DropTail
$ns duplex-link $n0 $n4 1mb 10s DropTail
$ns duplex-link $n0 $n5 1mb 10s DropTail
$ns at 5.0 "finish"
$ns run
